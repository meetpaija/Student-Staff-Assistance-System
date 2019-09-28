package com.assistance.studentstaff.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.UserRoleModel;
import com.assistance.studentstaff.service.IUserRolesService;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class UserRolesController extends ResponseUtility {
	
	@Autowired
	IUserRolesService userRolesService;
	
	@GetMapping
	public ResponseEntity<ApiResponse> fetchAllUserRoles() {
		return buildSuccessResponse(userRolesService.fetchAllUserRoles());
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> insertNewRole(@Valid @RequestBody UserRoleModel userRole) throws CustomGenericException {
		return buildSuccessResponse(userRolesService.insertNewRole(userRole));
	}
	
	@PutMapping("/{roleId}")
	public ResponseEntity<ApiResponse> updateRole(@PathVariable("roleId") String roleId, @Valid @RequestBody UserRoleModel userRole) throws CustomGenericException {
		return buildSuccessResponse(userRolesService.updateRole(roleId, userRole));
	}
	
	@DeleteMapping("/{roleId}")
	public ResponseEntity<ApiResponse> deleteRole(@PathVariable("roleId") String roleId) throws CustomGenericException {
		userRolesService.deleteRole(roleId);
		return buildSuccessResponse();
	}

}
