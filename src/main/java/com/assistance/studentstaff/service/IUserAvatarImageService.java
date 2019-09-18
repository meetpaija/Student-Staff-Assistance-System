package com.assistance.studentstaff.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.UserAvatarImage;

@Repository
public interface IUserAvatarImageService {

	UserAvatarImage saveAvatarImg(String userId, MultipartFile file) throws CustomGenericException;

	UserAvatarImage fetchAvatarImage(String userId) throws CustomGenericException;
	
}
