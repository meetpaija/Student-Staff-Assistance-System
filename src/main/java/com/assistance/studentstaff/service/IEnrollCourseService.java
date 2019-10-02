package com.assistance.studentstaff.service;

import java.util.List;

import javax.validation.Valid;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.EnrollCourseIdModel;
import com.assistance.studentstaff.model.EnrollCourseModel;

public interface IEnrollCourseService {

	List<EnrollCourseModel> fetchAllEnrolledCoursesByUserId(String userId);

	List<EnrollCourseModel> enrollCourses(String userId, @Valid List<String> courses) throws CustomGenericException;

	List<EnrollCourseModel> fetchAllEnrolledCourses(Boolean approved);

	EnrollCourseModel approveCourse(String userId, EnrollCourseIdModel enrollCourseId) throws CustomGenericException;

}
