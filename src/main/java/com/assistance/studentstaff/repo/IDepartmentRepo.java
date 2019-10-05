package com.assistance.studentstaff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.DepartmentModel;

@Repository
public interface IDepartmentRepo extends JpaRepository<DepartmentModel, String> {

	@Query("select dept from DepartmentModel dept where dept.deptName = :deptName")
	Optional<DepartmentModel> findByDeptName(String deptName);

}
