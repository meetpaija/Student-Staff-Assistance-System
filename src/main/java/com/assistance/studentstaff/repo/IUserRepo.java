package com.assistance.studentstaff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.User;

@Repository
public interface IUserRepo extends JpaRepository<User, String>{

	@Query("SELECT user FROM User user where user.emailId = :emailId")
	Optional<User> findByEmailId(String emailId);

	@Query("SELECT count(*) FROM User user where user.emailId = :emailId or user.userName = :userName")
	int findByEmailIdOrUserName(String emailId, String userName);

}
