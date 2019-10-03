package com.assistance.studentstaff.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "activity_trace")
@JsonInclude(value = Include.NON_NULL)
public class ActivityTraceModel implements Serializable {

	private static final long serialVersionUID = -3160192224129106196L;

	@Id
	@Column(name = "activity_id")
	private String activityId;

	@Column(name = "description")
	private String description;

	@Column(name = "username")
	private String userName;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "timestamp")
	private String timestamp;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
