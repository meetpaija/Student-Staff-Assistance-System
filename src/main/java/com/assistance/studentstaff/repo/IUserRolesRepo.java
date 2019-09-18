package com.assistance.studentstaff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.UserRole;

@Repository
public interface IUserRolesRepo extends JpaRepository<UserRole, String>{

	@Query("SELECT role FROM UserRole role where role.type = :type")
	Optional<UserRole> findByType(String type);

}
