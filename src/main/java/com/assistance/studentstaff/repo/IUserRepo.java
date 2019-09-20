package com.assistance.studentstaff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.UserModel;

@Repository
public interface IUserRepo extends JpaRepository<UserModel, String>{

	@Query("SELECT user FROM UserModel user where user.emailId = :emailId")
	Optional<UserModel> findByEmailId(String emailId);

	@Query("SELECT user FROM UserModel user where user.emailId = :emailId or user.userName = :userName")
	Optional<UserModel> findByEmailIdOrUserName(String emailId, String userName);

}
