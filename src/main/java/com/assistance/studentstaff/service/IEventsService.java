package com.assistance.studentstaff.service;

import java.util.List;

import javax.validation.Valid;

import com.assistance.studentstaff.common.CustomGenericException;
import com.assistance.studentstaff.model.EventsModel;

public interface IEventsService {

	List<EventsModel> fetchAllEvents(String userId);

	EventsModel fetchById(String eventId) throws CustomGenericException;

	EventsModel insertEvent(String userId, @Valid EventsModel event) throws CustomGenericException;

	EventsModel updateEvent(String userId, String eventId, @Valid EventsModel event) throws CustomGenericException;

	void deleteEvent(String eventId) throws CustomGenericException;

}
