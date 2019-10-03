package com.assistance.studentstaff.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assistance.studentstaff.model.EventsModel;

@Repository
public interface IEventRepo extends JpaRepository<EventsModel, String>{

	@Query("select e from EventsModel e where e.createdBy = :userId")
	List<EventsModel> findByUserId(String userId);

	@Query("select e from EventsModel e where e.eventId = :eventId")
	EventsModel findByEventId(String eventId);
}
