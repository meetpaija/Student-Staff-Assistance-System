package com.assistance.studentstaff.service.impl;

import static com.assistance.studentstaff.common.CommonConstants.STUDENT;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.DiscussionChatModel;
import com.assistance.studentstaff.model.DiscussionThreadModel;
import com.assistance.studentstaff.model.UserModel;
import com.assistance.studentstaff.model.UserRoleModel;
import com.assistance.studentstaff.repo.IDiscussionChatRepo;
import com.assistance.studentstaff.repo.IDiscussionThreadRepo;
import com.assistance.studentstaff.repo.IUserRepo;
import com.assistance.studentstaff.service.IDiscussionService;
import com.assistance.studentstaff.service.IUserRolesService;
import com.assistance.studentstaff.service.IUserService;

@Service
public class DiscussionServiceImpl implements IDiscussionService {

	@Autowired
	IDiscussionThreadRepo discThreadRepo;

	@Autowired
	IDiscussionChatRepo discChatRepo;

	@Autowired
	IUserService userService;

	@Autowired
	IUserRolesService userRolesService;

	@Autowired
	IUserRepo userRepo;

	@Override
	public DiscussionThreadModel createDiscThread(String userId, DiscussionThreadModel discThreadModel)
			throws CustomGenericException {
		UserModel user = findUserById(userId);
		UserRoleModel roleModel = userRolesService.findUserRoleById(user.getRoleId());

		if (!StringUtils.equalsIgnoreCase(STUDENT, roleModel.getType())) {
			discThreadModel.setDiscussionThreadId(UUID.randomUUID().toString());
			discThreadModel.setCreatedBy(userId);
			discThreadModel.setUpdatedBy(userId);
			discThreadModel.setCreatedByUserName(user.getUserName());
			discThreadModel.setUpdatedByUserName(user.getUserName());
			discThreadModel.setTimestamp(Timestamp.from(Calendar.getInstance().toInstant()));
			return discThreadRepo.save(discThreadModel);
		} else {
			throw new CustomGenericException("You are not allowed to create any discussion");
		}
	}

	private UserModel findUserById(String userId) throws CustomGenericException {
		UserModel user = new UserModel();
		Optional<UserModel> userOptionalModel = userRepo.findById(userId);
		if (userOptionalModel.isPresent()) {
			user = userOptionalModel.get();
		} else {
			throw new CustomGenericException("User doesn't exist");
		}
		return user;
	}

	@Override
	public DiscussionChatModel insertDiscChat(String userId, String discThreadId, DiscussionChatModel discChatModel)
			throws CustomGenericException {
		UserModel user = findUserById(userId);
		if (discThreadRepo.existsById(discThreadId)) {
			discChatModel.setDiscChatId(UUID.randomUUID().toString());
			discChatModel.setDiscThreadId(discThreadId);
			discChatModel.setUserId(userId);
			discChatModel.setUserName(user.getUserName());
			discChatModel.setTimestamp(Timestamp.from(Calendar.getInstance().toInstant()));
			return discChatRepo.save(discChatModel);
		} else {
			throw new CustomGenericException("Discussion thread doen't exist");
		}
	}

	@Override
	public List<DiscussionChatModel> fetchDiscChats(String discThreadId) throws CustomGenericException {
		if (discThreadRepo.existsById(discThreadId)) {
			return discChatRepo.fetchDiscChatsInDescOrder(discThreadId);
		} else {
			throw new CustomGenericException("Discussion thread doen't exist");
		}
	}

	@Override
	public DiscussionThreadModel updateDiscThread(String userId, String discThreadId,
			DiscussionThreadModel discThreadModel) throws CustomGenericException {
		UserModel user = findUserById(userId);
		DiscussionThreadModel existingDiscThreadModel = findDiscThreadById(discThreadId);
		UserRoleModel roleModel = userRolesService.findUserRoleById(user.getRoleId());

		if (!StringUtils.equalsIgnoreCase(STUDENT, roleModel.getType())) {
			discThreadModel.setDiscussionThreadId(discThreadId);
			discThreadModel.setCreatedBy(existingDiscThreadModel.getCreatedBy());
			discThreadModel.setUpdatedBy(userId);
			discThreadModel.setCreatedByUserName(existingDiscThreadModel.getCreatedByUserName());
			discThreadModel.setUpdatedByUserName(user.getUserName());
			discThreadModel.setTimestamp(Timestamp.from(Calendar.getInstance().toInstant()));
			return discThreadRepo.save(discThreadModel);
		} else {
			throw new CustomGenericException("You are not allowed to create any discussion");
		}
	}

	private DiscussionThreadModel findDiscThreadById(String discThreadId) throws CustomGenericException {
		Optional<DiscussionThreadModel> existingDiscThreadModel = discThreadRepo.findById(discThreadId);
		if (existingDiscThreadModel.isPresent()) {
			return existingDiscThreadModel.get();
		} else {
			throw new CustomGenericException("Discussion thread doesn't exist");
		}
	}

	@Override
	public DiscussionChatModel updateDiscChat(String userId, String discThreadId, String discChatId,
			DiscussionChatModel discChatModel) throws CustomGenericException {

		UserModel user = findUserById(userId);
		VerifyDiscThread(discThreadId);
		VerifyDiscChat(discChatId);

		discChatModel.setDiscChatId(discChatId);
		discChatModel.setDiscThreadId(discThreadId);
		discChatModel.setUserId(userId);
		discChatModel.setUserName(user.getUserName());
		discChatModel.setTimestamp(Timestamp.from(Calendar.getInstance().toInstant()));
		return discChatRepo.save(discChatModel);
	}

	private void VerifyDiscChat(String discChatId) throws CustomGenericException {
		if (!discChatRepo.existsById(discChatId))
			throw new CustomGenericException("Discussion Chat doen't exist");
	}

	private void VerifyDiscThread(String discThreadId) throws CustomGenericException {
		if (!discThreadRepo.existsById(discThreadId))
			throw new CustomGenericException("Discussion Thread doen't exist");
	}

	private DiscussionChatModel findDiscChatById(String discChatId) throws CustomGenericException {
		Optional<DiscussionChatModel> discussionChatModel = discChatRepo.findById(discChatId);
		if (discussionChatModel.isPresent()) {
			return discussionChatModel.get();
		} else {
			throw new CustomGenericException("Discussion Chat doen't exist");
		}
	}

	@Override
	public List<DiscussionThreadModel> fetchDiscThreads() throws CustomGenericException {
		return discThreadRepo.findAll();
	}

	@Override
	public void deleteDiscThread(String discThreadId) throws CustomGenericException {
		findDiscThreadById(discThreadId);
		discThreadRepo.deleteById(discThreadId);
	}

	@Override
	public void deleteDiscChat(String discChatId) throws CustomGenericException {
		findDiscChatById(discChatId);
		discChatRepo.deleteById(discChatId);
	}

}
