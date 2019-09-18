package com.assistance.studentstaff.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.User;
import com.assistance.studentstaff.model.UserAvatarImage;
import com.assistance.studentstaff.repo.IUserAvatarImageRepo;
import com.assistance.studentstaff.repo.IUserRepo;
import com.assistance.studentstaff.service.IUserAvatarImageService;

@Service
public class UserAvatarImageServiceImpl implements IUserAvatarImageService {

	@Autowired
	IUserRepo userRepo;

	@Autowired
	IUserAvatarImageRepo userAvatarImageRepo;

	public UserAvatarImage saveImage(String userId, MultipartFile file) {
		UserAvatarImage image = new UserAvatarImage();
		image.setUserId(userId);
		image.setContentType(file.getContentType());
		image.setLength(file.getSize());
		try {
			image.setAvatar(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userAvatarImageRepo.save(image);
	}

	public UserAvatarImage fetchImage(String userId) throws CustomGenericException {
		Optional<UserAvatarImage> image = userAvatarImageRepo.findById(userId);
		if (image.isPresent()) {
			return image.get();
		} else {
			throw new CustomGenericException("Image doesn't exist for this user");
		}
	}

	@Override
	public UserAvatarImage saveAvatarImg(String userId, MultipartFile file) throws CustomGenericException {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			return saveImage(userId, file);
		} else {
			throw new CustomGenericException("User doen't exist");
		}
	}

	@Override
	public UserAvatarImage fetchAvatarImage(String userId) throws CustomGenericException {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			return fetchImage(userId);
		} else {
			throw new CustomGenericException("User doesn't exist");
		} 
	}
}
