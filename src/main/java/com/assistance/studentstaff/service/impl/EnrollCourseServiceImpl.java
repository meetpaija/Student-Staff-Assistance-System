package com.assistance.studentstaff.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.EnrollCourseIdModel;
import com.assistance.studentstaff.model.EnrollCourseModel;
import com.assistance.studentstaff.repo.IEnrollCourseRepo;
import com.assistance.studentstaff.service.ICourseService;
import com.assistance.studentstaff.service.IEnrollCourseService;

@Service
public class EnrollCourseServiceImpl implements IEnrollCourseService{

	@Autowired
	IEnrollCourseRepo enrollCourseRepo;
	
	@Autowired
	ICourseService courseService;
	
	@Override
	public List<EnrollCourseModel> fetchAllEnrolledCourses(String userId) {
		return enrollCourseRepo.fetchAllEnrolledCourses(userId);
	}

	@Override
	public List<EnrollCourseModel> enrollCourses(String userId, List<String> courseIds) throws CustomGenericException {
		List<EnrollCourseModel> enrolledCourses = new ArrayList<EnrollCourseModel>();
		for (String courseId : courseIds) {
			courseService.findCourseById(courseId);
			checkAlreadyEnrolledOrNot(userId, courseId);
			EnrollCourseIdModel enrollCourseId = new EnrollCourseIdModel();
			enrollCourseId.setCourseId(courseId);
			enrollCourseId.setUserId(userId);
			EnrollCourseModel enrollCourse = new EnrollCourseModel();
			enrollCourse.setEnrollCourseId(enrollCourseId);
			enrollCourse.setStatus("ACTIVE");
			enrolledCourses.add(enrollCourseRepo.save(enrollCourse));
		}
		return enrolledCourses;
	}

	private void checkAlreadyEnrolledOrNot(String userId, String courseId) throws CustomGenericException {
		int count = enrollCourseRepo.fetchCount(userId, courseId);
		if(count>0) {
			throw new CustomGenericException("Check again, Course is already enrolled");
		}
	}

}
