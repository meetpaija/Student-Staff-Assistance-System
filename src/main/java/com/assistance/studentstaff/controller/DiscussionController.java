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
import com.assistance.studentstaff.model.DiscussionChatModel;
import com.assistance.studentstaff.model.DiscussionThreadModel;
import com.assistance.studentstaff.service.IDiscussionService;

@RestController
@CrossOrigin
@RequestMapping
public class DiscussionController extends ResponseUtility {

	@Autowired
	IDiscussionService discService;

	@PostMapping("/users/{userId}/discussionThreads")
	public ResponseEntity<ApiResponse> createDiscussionThread(@PathVariable("userId") String userId,
			@Valid @RequestBody DiscussionThreadModel discThreadModel) throws CustomGenericException {
		return buildSuccessResponse(discService.createDiscThread(userId, discThreadModel));
	}

	@PutMapping("/users/{userId}/discussionThreads/{discThreadId}")
	public ResponseEntity<ApiResponse> uppdateDiscussionThread(@PathVariable("userId") String userId,
			@PathVariable("discThreadId") String discThreadId,
			@Valid @RequestBody DiscussionThreadModel discThreadModel) throws CustomGenericException {
		return buildSuccessResponse(discService.updateDiscThread(userId, discThreadId, discThreadModel));
	}

	@PostMapping("/users/{userId}/discussionThreads/{discThreadId}/discussionChats")
	public ResponseEntity<ApiResponse> insertDiscChat(@PathVariable("userId") String userId,
			@PathVariable("discThreadId") String discThreadId, @Valid @RequestBody DiscussionChatModel discChatModel)
			throws CustomGenericException {
		return buildSuccessResponse(discService.insertDiscChat(userId, discThreadId, discChatModel));
	}

	@PutMapping("/users/{userId}/discussionThreads/{discThreadId}/discussionChats/{discChatId}")
	public ResponseEntity<ApiResponse> updateDiscChat(@PathVariable("userId") String userId,
			@PathVariable("discThreadId") String discThreadId, @PathVariable("discChatId") String discChatId,
			@Valid @RequestBody DiscussionChatModel discChatModel) throws CustomGenericException {
		return buildSuccessResponse(discService.updateDiscChat(userId, discThreadId, discChatId, discChatModel));
	}

	@GetMapping("/discussionThreads/{discThreadId}/discussionChats")
	public ResponseEntity<ApiResponse> fetchDiscChats(@PathVariable("discThreadId") String discThreadId)
			throws CustomGenericException {
		return buildSuccessResponse(discService.fetchDiscChats(discThreadId));
	}
	
	@DeleteMapping("/discussionThreads/{discThreadId}")
	public ResponseEntity<ApiResponse> deleteDiscThread(@PathVariable("discThreadId") String discThreadId)
			throws CustomGenericException {
		discService.deleteDiscThread(discThreadId);
		return buildSuccessResponse();
	}
	
	@DeleteMapping("/discussionChats/{discChatId}")
	public ResponseEntity<ApiResponse> deleteDiscChat(@PathVariable("discChatId") String discChatId)
			throws CustomGenericException {
		discService.deleteDiscChat(discChatId);
		return buildSuccessResponse();
	}

	@GetMapping("/discussionThreads")
	public ResponseEntity<ApiResponse> fetchDiscThreads() throws CustomGenericException {
		return buildSuccessResponse(discService.fetchDiscThreads());
	}

}
