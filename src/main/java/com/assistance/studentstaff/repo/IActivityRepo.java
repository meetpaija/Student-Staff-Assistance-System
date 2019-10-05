package com.assistance.studentstaff.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.ActivityTraceModel;

@Repository
public interface IActivityRepo extends JpaRepository<ActivityTraceModel, String> {

	@Query("select e from ActivityTraceModel e where e.userId = :userId")
	List<ActivityTraceModel> findByUserId(String userId);
}
