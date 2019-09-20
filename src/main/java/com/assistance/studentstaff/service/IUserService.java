package com.assistance.studentstaff.service;

import java.util.List;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.UserModel;

public interface IUserService {

	public List<UserModel> fetchAllUsers();

	public UserModel findById(String userId) throws CustomGenericException;

	public UserModel insertUser(UserModel user) throws CustomGenericException;

	public UserModel updateUser(String userId, UserModel user) throws CustomGenericException;

	public void deleteUser(String userId) throws CustomGenericException;

	public UserModel loginUser(String userNameOrEmailId, String password) throws CustomGenericException;

	public UserModel changePassword(String userId, String newPassword) throws CustomGenericException;
}
