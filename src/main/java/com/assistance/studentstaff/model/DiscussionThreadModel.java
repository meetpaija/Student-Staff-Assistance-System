package com.assistance.studentstaff.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "discussion_thread")
@JsonInclude(value = Include.NON_NULL)
public class DiscussionThreadModel implements Serializable{

	private static final long serialVersionUID = -3801444611208949218L;

	@Id
	@Column(name = "DISC_THREAD_ID",nullable=false)
	private String discussionThreadId;

	@Column(name = "TOPIC_NAME")
	@NotBlank
	private String topicName;

	@Column(name = "TOPIC_DESC")
	private String topicDesc;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;

	@Column(name = "CREATED_BY_USERNAME")
	private String createdByUserName;
	
	@Column(name = "UPDATED_BY_USERNAME")
	private String updatedByUserName;

	public String getDiscussionThreadId() {
		return discussionThreadId;
	}

	public void setDiscussionThreadId(String discussionThreadId) {
		this.discussionThreadId = discussionThreadId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDesc() {
		return topicDesc;
	}

	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getCreatedByUserName() {
		return createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName) {
		this.createdByUserName = createdByUserName;
	}

	public String getUpdatedByUserName() {
		return updatedByUserName;
	}

	public void setUpdatedByUserName(String updatedByUserName) {
		this.updatedByUserName = updatedByUserName;
	}
	
}
