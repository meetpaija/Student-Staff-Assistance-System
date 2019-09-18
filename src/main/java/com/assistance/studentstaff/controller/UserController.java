package com.assistance.studentstaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.User;
import com.assistance.studentstaff.service.IUserAvatarImageService;
import com.assistance.studentstaff.service.IUserService;

@RestController
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
	public ResponseEntity<ApiResponse> insertUser(@RequestBody User user) throws CustomGenericException {
		return buildSuccessResponse(userService.insertUser(user));
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