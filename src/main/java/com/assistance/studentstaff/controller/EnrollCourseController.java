package com.assistance.studentstaff.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.service.IEnrollCourseService;

@RestController
@CrossOrigin
@RequestMapping("/users/{userId}/enrollCourses")
public class EnrollCourseController extends ResponseUtility {

	@Autowired
	IEnrollCourseService enrollCourseService;

	@GetMapping
	public ResponseEntity<ApiResponse> fetchAllEnrolledCouses(@PathVariable("userId") String userId) {
		return buildSuccessResponse(enrollCourseService.fetchAllEnrolledCourses(userId));
	}

	@PostMapping
	public ResponseEntity<ApiResponse> insertDocument(@PathVariable("userId") String userId,
			@Valid @RequestBody List<String> courseIds) throws CustomGenericException {
		return buildSuccessResponse(enrollCourseService.enrollCourses(userId, courseIds));
	}
}