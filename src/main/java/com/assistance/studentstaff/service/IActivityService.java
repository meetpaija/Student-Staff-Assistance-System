package com.assistance.studentstaff.service;

import java.util.List;

import com.assistance.studentstaff.model.ActivityTraceModel;

public interface IActivityService {

	public List<ActivityTraceModel> fetchAllAcivityTrace();

	public List<ActivityTraceModel> fetchAcivityTraceByUserId(String userId);
}
