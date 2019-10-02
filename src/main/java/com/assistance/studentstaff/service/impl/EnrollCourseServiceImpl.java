package com.assistance.studentstaff.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CommonConstants;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.EnrollCourseIdModel;
import com.assistance.studentstaff.model.EnrollCourseModel;
import com.assistance.studentstaff.model.UserModel;
import com.assistance.studentstaff.model.UserRoleModel;
import com.assistance.studentstaff.repo.IEnrollCourseRepo;
import com.assistance.studentstaff.repo.IUserRepo;
import com.assistance.studentstaff.service.ICourseService;
import com.assistance.studentstaff.service.IEnrollCourseService;
import com.assistance.studentstaff.service.IUserRolesService;

@Service
public class EnrollCourseServiceImpl implements IEnrollCourseService{

	@Autowired
	private IEnrollCourseRepo enrollCourseRepo;
	
	@Autowired
	private ICourseService courseService;

	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private IUserRolesService userRoleService;
	
	@Override
	public List<EnrollCourseModel> fetchAllEnrolledCoursesByUserId(String userId) {
		return enrollCourseRepo.fetchAllEnrolledCoursesByUserId(userId);
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
			enrollCourse.setApproved(false);
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

	@Override
	public List<EnrollCourseModel> fetchAllEnrolledCourses(Boolean approved) {
		if(approved==null)
			return enrollCourseRepo.findAll();
		else {
			return enrollCourseRepo.findEnrolledCoursesByStatus(approved);
		}
			
	}

	@Override
	public EnrollCourseModel approveCourse(String userId, EnrollCourseIdModel enrollCourseId) throws CustomGenericException {
		Optional<UserModel> user = userRepo.findById(userId);
		if(user.isPresent()) {
			UserRoleModel role = userRoleService.findUserRoleById(user.get().getRoleId());
			if(StringUtils.equals(role.getType(), CommonConstants.ADMIN)) {
				Optional<EnrollCourseModel> existingEnrollCourse = enrollCourseRepo.findById(enrollCourseId);
				if(existingEnrollCourse.isPresent()) {
					EnrollCourseModel existingEnrollCourseModel = existingEnrollCourse.get();
					existingEnrollCourseModel.setApproved(true);
					return enrollCourseRepo.save(existingEnrollCourseModel);
				} else {
					throw new CustomGenericException("Check again, Course is not available to enroll");
				}
			} else {
				throw new CustomGenericException("Only Admin can approve the course");
			}
		} else {
			throw new CustomGenericException("User doesn't exist");
		}
	}

}
