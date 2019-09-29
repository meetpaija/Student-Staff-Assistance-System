package com.assistance.studentstaff.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.CourseModel;
import com.assistance.studentstaff.service.ICourseService;

@RestController
@CrossOrigin
@RequestMapping
public class CourseController extends ResponseUtility {

	@Autowired
	ICourseService courseService;

	@GetMapping("/departments/{deptId}/programs/{progId}/courses")
	public ResponseEntity<ApiResponse> fetchAllcourses(@PathVariable("deptId") String deptId,
			@PathVariable("progId") String progId) {
		return buildSuccessResponse(courseService.fetchAllCourse(deptId, progId));
	}

	@GetMapping("/courses/{courseId}")
	public ResponseEntity<ApiResponse> fetchCourseById(@PathVariable("courseId") String courseId)
			throws CustomGenericException {
		return buildSuccessResponse(courseService.findCourseById(courseId));
	}

	@PostMapping("/departments/{deptId}/programs/{progId}/courses")
	public ResponseEntity<ApiResponse> insertNewRole(@PathVariable("deptId") String deptId,
			@PathVariable("progId") String progId,
			@Valid @RequestBody CourseModel course)
			throws CustomGenericException {
		return buildSuccessResponse(courseService.insertCourse(deptId, progId, course));
	}

	@PutMapping("/departments/{deptId}/programs/{progId}/courses/{courseId}")
	public ResponseEntity<ApiResponse> updateRole(@PathVariable("deptId") String deptId,
			@PathVariable("progId") String progId,
			@PathVariable("courseId") String courseId,
			@Valid @RequestBody CourseModel course) throws CustomGenericException {
		return buildSuccessResponse(courseService.updateCourse(deptId, progId, courseId, course));
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<ApiResponse> deleteRole(@PathVariable("courseId") String courseId)
			throws CustomGenericException {
		courseService.deleteCourse(courseId);
		return buildSuccessResponse();
	}
}
