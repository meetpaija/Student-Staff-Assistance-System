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

import com.assistance.studentstaff.common.ApiResponse;
import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.common.ResponseUtility;
import com.assistance.studentstaff.model.EventsModel;
import com.assistance.studentstaff.service.IEventsService;

@RestController
//@CrossOrigin
@RequestMapping
public class EventsController extends ResponseUtility {

	@Autowired
	IEventsService eventService;

	@GetMapping("/events")
	public ResponseEntity<ApiResponse> fetchAllEvents(@RequestParam(value = "userId", required = false) String userId)
			throws CustomGenericException {
		return buildSuccessResponse(eventService.fetchAllEvents(userId));
	}

	@GetMapping("/events/{eventId}")
	public ResponseEntity<ApiResponse> fetchEventById(@PathVariable("eventId") String eventId)
			throws CustomGenericException {
		return buildSuccessResponse(eventService.fetchById(eventId));
	}

	@PostMapping("/users/{userId}/events")
	public ResponseEntity<ApiResponse> insertEvent(@PathVariable("userId") String userId,
			@Valid @RequestBody EventsModel event) throws CustomGenericException {
		return buildSuccessResponse(eventService.insertEvent(userId, event));
	}

	@PutMapping("/users/{userId}/events/{eventId}")
	public ResponseEntity<ApiResponse> updateEvent(@PathVariable("userId") String userId,
			@PathVariable("eventId") String eventId, @Valid @RequestBody EventsModel event)
			throws CustomGenericException {
		return buildSuccessResponse(eventService.updateEvent(userId, eventId, event));
	}
	
	@DeleteMapping("/events/{eventId}")
	public ResponseEntity<ApiResponse> deleteEvent(@PathVariable("eventId") String eventId)
					throws CustomGenericException {
		eventService.deleteEvent(eventId);
		return buildSuccessResponse();
	}
}
