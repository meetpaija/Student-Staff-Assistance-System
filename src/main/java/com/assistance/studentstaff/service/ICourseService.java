package com.assistance.studentstaff.service;

import java.util.List;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.CourseModel;

public interface ICourseService {

	List<CourseModel> fetchAllCourse();

	CourseModel insertCourse(CourseModel course) throws CustomGenericException;

	CourseModel updateCourse(String courseId, CourseModel course) throws CustomGenericException;

	void deleteCourse(String courseId) throws CustomGenericException;
	
	CourseModel findCourseById(String courseId) throws CustomGenericException;
}
