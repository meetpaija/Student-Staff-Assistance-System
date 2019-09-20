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
@Table(name = "discussion_chats")
@JsonInclude(value = Include.NON_NULL)

public class DiscussionChatModel implements Serializable{

	private static final long serialVersionUID = 4183672330339721311L;

	@Id
	@Column(name = "DISC_CHAT_ID",nullable=false)
	private String discChatId;

	@Column(name = "CHAT_DESC")
	@NotBlank
	private String chatDesc;

	@Column(name = "DISC_THREAD_ID")
	private String discThreadId;
	
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;

	public String getDiscChatId() {
		return discChatId;
	}

	public void setDiscChatId(String discChatId) {
		this.discChatId = discChatId;
	}

	public String getChatDesc() {
		return chatDesc;
	}

	public void setChatDesc(String chatDesc) {
		this.chatDesc = chatDesc;
	}

	public String getDiscThreadId() {
		return discThreadId;
	}

	public void setDiscThreadId(String discThreadId) {
		this.discThreadId = discThreadId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
