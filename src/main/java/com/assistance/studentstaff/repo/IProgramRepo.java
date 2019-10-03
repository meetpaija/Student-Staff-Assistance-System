package com.assistance.studentstaff.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.ProgramModel;

@Repository
public interface IProgramRepo extends JpaRepository<ProgramModel, String> {

	@Query("select prog from ProgramModel prog where prog.progName=:progName")
	Optional<ProgramModel> findByProgName(String progName);

	@Query("select prog from ProgramModel prog where prog.deptId=:deptId")
	List<ProgramModel> findByDeptId(String deptId);

	@Query("select prog from ProgramModel prog")
	List<ProgramModel> findAll();

}
