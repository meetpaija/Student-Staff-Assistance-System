package com.assistance.studentstaff.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.UserAvatarImage;

@Repository
public interface IUserAvatarImageRepo extends JpaRepository<UserAvatarImage, String>{

}
