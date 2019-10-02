package com.assistance.studentstaff.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.CourseModel;
import com.assistance.studentstaff.repo.ICourseRepo;
import com.assistance.studentstaff.service.ICourseService;
import com.assistance.studentstaff.service.IDepartmentService;
import com.assistance.studentstaff.service.IProgramService;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	ICourseRepo courseRepo;

	@Autowired
	IDepartmentService deptService;

	@Autowired
	IProgramService progService;

	@Override
	public List<CourseModel> fetchAllCourseByDeptAndProg(String deptId, String progId) throws CustomGenericException {
		deptService.findDeptById(deptId);
		progService.findProgramById(progId);
		return courseRepo.findByDeptAndProgram(deptId, progId);
	}

	@Override
	public CourseModel insertCourse(String deptId, String progId, CourseModel course) throws CustomGenericException {
		CourseModel existingCourse = courseRepo.findByName(course.getCourseName());
		if (existingCourse != null) {
			throw new CustomGenericException("course is already exists");
		} else {
			deptService.findDeptById(course.getDeptId());
			progService.findProgramById(course.getProgId());
			course.setCourseId(UUID.randomUUID().toString());
			return courseRepo.save(course);
		}
	}

	@Override
	public CourseModel updateCourse(String deptId, String progId, String courseId, CourseModel newCourse)
			throws CustomGenericException {
		CourseModel oldCourse = courseRepo.findCourseById(courseId);
		if (oldCourse != null) {
			deptService.findDeptById(newCourse.getDeptId());
			progService.findProgramById(newCourse.getProgId());
			newCourse.setCourseId(courseId);
			return courseRepo.save(newCourse);
		} else {
			throw new CustomGenericException("This course doen't exists");
		}
	}

	@Override
	public void deleteCourse(String courseId) throws CustomGenericException {
		Optional<CourseModel> existingCourse = courseRepo.findById(courseId);
		if (existingCourse.isPresent()) {
			courseRepo.deleteById(courseId);
		} else {
			throw new CustomGenericException("This course doen't exists");
		}
	}

	@Override
	public CourseModel findCourseById(String courseId) throws CustomGenericException {
		Optional<CourseModel> existingCourse = courseRepo.findById(courseId);
		if (existingCourse.isPresent()) {
			return existingCourse.get();
		} else {
			throw new CustomGenericException("This course doen't exists");
		}
	}

	@Override
	public List<CourseModel> fetchAllCourse() throws CustomGenericException {
		return courseRepo.findAll();
	}

}
