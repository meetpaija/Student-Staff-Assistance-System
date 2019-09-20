package com.assistance.studentstaff.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.UserAvatarImageModel;

@Repository
public interface IUserAvatarImageService {

	UserAvatarImageModel saveAvatarImg(String userId, MultipartFile file) throws CustomGenericException;

	UserAvatarImageModel fetchAvatarImage(String userId) throws CustomGenericException;
	
}
