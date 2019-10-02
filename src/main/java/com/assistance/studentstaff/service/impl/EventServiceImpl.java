package com.assistance.studentstaff.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CommonConstants;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.EventsModel;
import com.assistance.studentstaff.model.UserModel;
import com.assistance.studentstaff.model.UserRoleModel;
import com.assistance.studentstaff.repo.IEventRepo;
import com.assistance.studentstaff.repo.IUserRepo;
import com.assistance.studentstaff.service.IEventsService;
import com.assistance.studentstaff.service.IUserRolesService;

@Service
public class EventServiceImpl implements IEventsService{

	@Autowired
	IEventRepo eventRepo;
	
	@Autowired
	IUserRepo userRepo;
	
	@Autowired
	IUserRolesService userRoleService;
	
	@Override
	public List<EventsModel> fetchAllEvents(String userId) {
		if(StringUtils.isEmpty(userId)) {
			return eventRepo.findAll();
		} else {
			return eventRepo.findByUserId(userId);
		}
	}

	@Override
	public EventsModel fetchById(String eventId) throws CustomGenericException {
		Optional<EventsModel> event = eventRepo.findById(eventId);
		if(event.isPresent()) {
			return event.get();
		} else {
			throw new CustomGenericException("This event doesn't exist");
		}
	}

	@Override
	public EventsModel insertEvent(String userId, EventsModel event) throws CustomGenericException {
		Optional<UserModel> existingUser = userRepo.findById(userId);
		if(!existingUser.isPresent()) {
			throw new CustomGenericException("User doesn't exist");
		}
		UserModel user = existingUser.get(); 
		UserRoleModel userRole = userRoleService.findUserRoleById(user.getRoleId());
		if(StringUtils.equalsIgnoreCase(userRole.getType(), CommonConstants.STAFF) 
				|| StringUtils.equalsIgnoreCase(userRole.getType(), CommonConstants.ADMIN)) {
			event.setEventId(UUID.randomUUID().toString());
			event.setCreatedBy(userId);
			event.setUpdatedBy(userId);
			event.setCreatedByUsername(user.getUserName());
			event.setUpdatedByUsername(user.getUserName());
			event.setTimestamp(Timestamp.from(Calendar.getInstance().toInstant()));
			return eventRepo.save(event);
		} else {
			throw new CustomGenericException("Only Admin and Staff can add any events");
		}
	}
	
	

}
