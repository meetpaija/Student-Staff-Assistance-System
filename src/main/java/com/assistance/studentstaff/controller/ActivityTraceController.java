package com.assistance.studentstaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.service.IActivityService;

@RestController
@CrossOrigin
@RequestMapping
public class ActivityTraceController extends ResponseUtility {

	@Autowired
	IActivityService activityService;

	@GetMapping("/activityTrace")
	public ResponseEntity<ApiResponse> fetchAllActivity() throws CustomGenericException {
		return buildSuccessResponse(activityService.fetchAllAcivityTrace());
	}

	@GetMapping("/users/{userId}/activityTrace")
	public ResponseEntity<ApiResponse> fetchActivityByUserId(@PathVariable("userId") String userId)
			throws CustomGenericException {
		return buildSuccessResponse(activityService.fetchAcivityTraceByUserId(userId));
	}
}
