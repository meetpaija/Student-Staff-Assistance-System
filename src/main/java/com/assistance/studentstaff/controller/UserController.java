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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.UserModel;
import com.assistance.studentstaff.service.IUserAvatarImageService;
import com.assistance.studentstaff.service.IUserService;

@RestController
//@CrossOrigin
@RequestMapping("/users")
public class UserController extends ResponseUtility {

	@Autowired
	IUserService userService;
	
	@Autowired
	IUserAvatarImageService userAvatarImageService;

	@GetMapping
	public ResponseEntity<ApiResponse> fetchAllUsers() {
		return buildSuccessResponse(userService.fetchAllUsers());
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> insertUser(@Valid @RequestBody UserModel user) throws CustomGenericException {
		return buildSuccessResponse(userService.insertUser(user));
	}
	
	@GetMapping("/login")
	public ResponseEntity<ApiResponse> loginUser(@RequestParam(value = "userNameOrEmailId", required = true) String userNameOrEmailId,
			@RequestParam(value = "password", required = true) String password) throws CustomGenericException {
		return buildSuccessResponse(userService.loginUser(userNameOrEmailId, password));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<ApiResponse> fetchUserById(@PathVariable("userId") String userId) throws CustomGenericException {
		return buildSuccessResponse(userService.findById(userId));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<ApiResponse> updateUser(@PathVariable("userId") String userId, @Valid @RequestBody UserModel user) throws CustomGenericException {
		return buildSuccessResponse(userService.updateUser(userId, user));
	}
	
	@PutMapping("/{userId}/changePassword")
	public ResponseEntity<ApiResponse> changePassword(@PathVariable("userId") String userId, @RequestParam(value = "newPassword", required = true) String newPassword) throws CustomGenericException {
		return buildSuccessResponse(userService.changePassword(userId, newPassword));
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") String userId) throws CustomGenericException {
		userService.deleteUser(userId);
		return buildSuccessResponse();
	}

	@PostMapping("/{userId}/avatar-img")
	public ResponseEntity<ApiResponse> saveAvatarImage(@PathVariable(value = "userId") String userId,
			@RequestParam("file") MultipartFile file) throws CustomGenericException {
		return buildSuccessResponse(userAvatarImageService.saveAvatarImg(userId, file));
	}

	@GetMapping("/{userId}/avatar-img")
	public ResponseEntity<ApiResponse> fetchAvatarImage(@PathVariable(value = "userId") String userId) throws CustomGenericException {
//		return buildFileFetchSuccessResponse(new InputStreamResource(new ByteArrayInputStream(image.getAvatar())),
//				MediaType.parseMediaType(image.getContentType()), image.getLength());
		return buildSuccessResponse(userAvatarImageService.fetchAvatarImage(userId));
	}

}