package com.assistance.studentstaff.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.model.ActivityTraceModel;
import com.assistance.studentstaff.repo.IActivityRepo;
import com.assistance.studentstaff.service.IActivityService;

@Service
public class ActivityTraceImpl implements IActivityService {

	@Autowired
	IActivityRepo activityRepo;
	
	@Override
	public List<ActivityTraceModel> fetchAllAcivityTrace() {
		return activityRepo.findAll(); 
	}

	@Override
	public List<ActivityTraceModel> fetchAcivityTraceByUserId(String userId) {
		return activityRepo.findByUserId(userId);
	}

}
