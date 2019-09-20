package com.assistance.studentstaff.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.UserRoleModel;
import com.assistance.studentstaff.repo.IUserRolesRepo;
import com.assistance.studentstaff.service.IUserRolesService;

@Service
public class UserRolesServiceImpl implements IUserRolesService {

	@Autowired
	IUserRolesRepo userRoleRepo;
	
	@Override
	public List<UserRoleModel> fetchAllUserRoles() {
		return userRoleRepo.findAll();
	}

	@Override
	public UserRoleModel insertNewRole(UserRoleModel userRole) throws CustomGenericException {
		Optional<UserRoleModel> existingUserRole = userRoleRepo.findByType(userRole.getType());
		if(existingUserRole.isPresent()) {
			throw new CustomGenericException("RoleType is already exists"); 
		} else {
			userRole.setRoleId(UUID.randomUUID().toString());
			return userRoleRepo.save(userRole);
		}
	}

	@Override
	public UserRoleModel updateRole(String roleId, UserRoleModel userRole) throws CustomGenericException {
		if(userRoleRepo.existsById(roleId)) {
			userRole.setRoleId(roleId);
			return userRoleRepo.save(userRole);
		} else {
			throw new CustomGenericException("This role doen't exists");
		}
	}

	@Override
	public void deleteRole(String roleId) throws CustomGenericException {
		if(userRoleRepo.existsById(roleId)) {
			userRoleRepo.deleteById(roleId);
		} else {
			throw new CustomGenericException("This role doen't exists");
		}
	}
	
	@Override
	public UserRoleModel findUserRoleById(String roleId) throws CustomGenericException {
		Optional<UserRoleModel> existingUserRole = userRoleRepo.findById(roleId);
		if(existingUserRole.isPresent()) {
			return existingUserRole.get();
		} else {
			throw new CustomGenericException("This role doen't exists");
		}
	}

}
