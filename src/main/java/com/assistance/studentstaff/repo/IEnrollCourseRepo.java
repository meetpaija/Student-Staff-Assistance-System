package com.assistance.studentstaff.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.EnrollCourseIdModel;
import com.assistance.studentstaff.model.EnrollCourseModel;

@Repository
public interface IEnrollCourseRepo extends JpaRepository<EnrollCourseModel, EnrollCourseIdModel>{

	@Query("select ec from EnrollCourseModel ec where ec.enrollCourseId.userId = :userId")
	List<EnrollCourseModel> fetchAllEnrolledCourses(String userId);

	@Query("select count(ec) from EnrollCourseModel ec where ec.enrollCourseId.userId = :userId and ec.enrollCourseId.courseId = :courseId")
	int fetchCount(String userId, String courseId);

}
