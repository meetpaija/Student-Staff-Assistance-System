package com.assistance.studentstaff.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class EnrollCourseIdModel implements Serializable{

	private static final long serialVersionUID = -3398506808062444230L;

	@Column(name = "user_id")
	@NotBlank
	private String userId;

	@Column(name = "course_id")
	@NotBlank
	private String courseId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
}

