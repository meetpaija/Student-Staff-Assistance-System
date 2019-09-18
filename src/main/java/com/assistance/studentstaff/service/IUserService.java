package com.assistance.studentstaff.service;

import java.util.List;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.User;

public interface IUserService {

	public List<User> fetchAllUsers();

	public User findById(String userId) throws CustomGenericException;

	public User insertUser(User user) throws CustomGenericException;
}
