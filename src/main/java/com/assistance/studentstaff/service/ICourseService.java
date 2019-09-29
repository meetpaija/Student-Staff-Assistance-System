package com.assistance.studentstaff.service;

import java.util.List;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.CourseModel;

public interface ICourseService {

	List<CourseModel> fetchAllCourse(String deptId, String progId);

	CourseModel insertCourse(String deptId, String progId, CourseModel course) throws CustomGenericException;

	CourseModel updateCourse(String courseId, String progId, String courseId2, CourseModel course) throws CustomGenericException;

	void deleteCourse(String courseId) throws CustomGenericException;
	
	CourseModel findCourseById(String courseId) throws CustomGenericException;
}
