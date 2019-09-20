package com.assistance.studentstaff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.UserRoleModel;

@Repository
public interface IUserRolesRepo extends JpaRepository<UserRoleModel, String>{

	@Query("SELECT role FROM UserRoleModel role where role.type = :type")
	Optional<UserRoleModel> findByType(String type);

}
