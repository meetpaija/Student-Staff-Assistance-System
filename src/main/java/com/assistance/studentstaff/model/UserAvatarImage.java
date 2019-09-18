package com.assistance.studentstaff.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "avatar_img")
@JsonInclude(value = Include.NON_NULL)
public class UserAvatarImage implements Serializable{

	private static final long serialVersionUID = -3478279473929101418L;

	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "LENGTH")
	private long length;
	
	@Column(name = "CONTENT_TYPE")
	private String contentType;
	
	@Column(name = "AVATAR_IMG")
	@Lob
	private byte[] avatar;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	
	
}
