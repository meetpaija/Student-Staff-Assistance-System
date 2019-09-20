package com.assistance.studentstaff.service;

import java.util.List;

import javax.validation.Valid;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.UserRoleModel;

public interface IUserRolesService {

	List<UserRoleModel> fetchAllUserRoles();

	UserRoleModel insertNewRole(UserRoleModel userRole) throws CustomGenericException;

	UserRoleModel updateRole(String roleId, UserRoleModel userRole) throws CustomGenericException;

	void deleteRole(String roleId) throws CustomGenericException;

	UserRoleModel findUserRoleById(String roleId) throws CustomGenericException;

}
