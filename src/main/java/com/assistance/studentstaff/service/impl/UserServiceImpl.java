package com.assistance.studentstaff.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.PasswordHashing;
import com.assistance.studentstaff.model.User;
import com.assistance.studentstaff.model.UserRole;
import com.assistance.studentstaff.repo.IUserRepo;
import com.assistance.studentstaff.repo.IUserRolesRepo;
import com.assistance.studentstaff.service.IUserAvatarImageService;
import com.assistance.studentstaff.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepo userRepo;

	@Autowired
	IUserRolesRepo userRolesRepo;

	@Autowired
	IUserAvatarImageService userAvatarImageService;

	@Override
	public List<User> fetchAllUsers() {
		List<User> users = userRepo.findAll();
		return users.stream().map(user -> setNullPassword(user)).collect(Collectors.toList());
	}

	private User setNullPassword(User user) {
		user.setPassword(null);
		return user;
	}

	@Override
	public User insertUser(User user) throws CustomGenericException {
		int usersCount = userRepo.findByEmailIdOrUserName(user.getEmailId(), user.getUserName());
		if (usersCount > 0) {
			throw new CustomGenericException("User already exists");
		}
		Optional<UserRole> userRole = userRolesRepo.findById(user.getRoleId());
		if (userRole.isPresent()) {
			user.setUserId(UUID.randomUUID().toString());
			user.setPassword(PasswordHashing.encrypt(user.getPassword()));
			return setNullPassword(userRepo.save(user));
		} else {
			throw new CustomGenericException("This role doesn't exists");
		}
	}

	@Override
	public User findById(String userId) throws CustomGenericException {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			return setNullPassword(user.get());
		} else {
			throw new CustomGenericException("User doesn't exist");
		}
	}

}
