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

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	ICourseRepo courseRepo;

	@Override
	public List<CourseModel> fetchAllCourse() {
		return courseRepo.findAll();
	}

	@Override
	public CourseModel insertCourse(CourseModel course) throws CustomGenericException {
		CourseModel existingCourse = courseRepo.findByName(course.getCourseName());
		if (existingCourse != null) {
			throw new CustomGenericException("course is already exists");
		} else {
			course.setCourseId(UUID.randomUUID().toString());
			return courseRepo.save(course);
		}
	}

	@Override
	public CourseModel updateCourse(String courseId, CourseModel newCourse) throws CustomGenericException {
		CourseModel oldCourse = courseRepo.findCourseById(courseId);
		if (oldCourse != null) {
			oldCourse.setCourseName(newCourse.getCourseName());
			oldCourse.setCourseDescription(newCourse.getCourseDescription());
			oldCourse.setActive(newCourse.getActive());
			return courseRepo.save(oldCourse);
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

}
