package com.assistance.studentstaff.service;

import java.util.List;

import javax.validation.Valid;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.UserRole;

public interface IUserRolesService {

	List<UserRole> fetchAllUserRoles();

	UserRole insertNewRole(UserRole userRole) throws CustomGenericException;

	UserRole updateRole(String roleId, @Valid UserRole userRole) throws CustomGenericException;

	void deleteRole(String roleId) throws CustomGenericException;

}
