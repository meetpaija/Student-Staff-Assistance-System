package com.assistance.studentstaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping
public class ForgetPasswordController extends ResponseUtility {
	
	@Autowired
	IUserService userService;
	
	@PutMapping("/emailId/{emailId}/forgetPassword")
	public ResponseEntity<ApiResponse> forgetPassword(@PathVariable("emailId") String emailId) throws CustomGenericException {
		userService.forgetPassword(emailId);
		return buildSuccessResponse();
	}

}
