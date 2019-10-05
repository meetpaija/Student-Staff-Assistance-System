package com.assistance.studentstaff.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.EnrollCourseIdModel;
import com.assistance.studentstaff.service.IEnrollCourseService;

@RestController
@CrossOrigin
@RequestMapping
public class EnrollCourseController extends ResponseUtility {

	@Autowired
	IEnrollCourseService enrollCourseService;

	@GetMapping("/enrollCourses")
	public ResponseEntity<ApiResponse> fetchAllEnrolledCouses(@RequestParam(value = "approved", required = false) Boolean approved) {
		return buildSuccessResponse(enrollCourseService.fetchAllEnrolledCourses(approved));
	}
	
	@GetMapping("/users/{userId}/enrollCourses")
	public ResponseEntity<ApiResponse> fetchAllEnrolledCousesByUserId(@PathVariable("userId") String userId) {
		return buildSuccessResponse(enrollCourseService.fetchAllEnrolledCoursesByUserId(userId));
	}

	@PostMapping("/users/{userId}/enrollCourses")
	public ResponseEntity<ApiResponse> enrollCourse(@PathVariable("userId") String userId,
			@Valid @RequestBody List<String> courseIds) throws CustomGenericException {
		return buildSuccessResponse(enrollCourseService.enrollCourses(userId, courseIds));
	}
	
	@PostMapping("/users/{userId}/approveCourse")
	public ResponseEntity<ApiResponse> approveCourses(@PathVariable("userId") String userId,
			@Valid @RequestBody EnrollCourseIdModel enrollCourseId) throws CustomGenericException {
		return buildSuccessResponse(enrollCourseService.approveCourse(userId, enrollCourseId));
	}
	
	@DeleteMapping("/enrolledCourse")
	public ResponseEntity<ApiResponse> deleteEnrolledCourse(
			@Valid @RequestBody EnrollCourseIdModel enrollCourseId) throws CustomGenericException {
		enrollCourseService.deleteEnrolledCourse(enrollCourseId);
		return buildSuccessResponse();
	}
}