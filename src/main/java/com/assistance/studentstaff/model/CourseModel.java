package com.assistance.studentstaff.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "courses")
@JsonInclude(value = Include.NON_NULL)
public class CourseModel implements Serializable {

	private static final long serialVersionUID = 2789226849578701827L;

	@Id
	@Column(name = "course_id", nullable = false)
	private String courseId;

	@Column(name = "name", nullable = false)
	private String courseName;

	@Column(name = "description")
	private String courseDescription;

	@Column(name = "active", nullable = false)
	private int active;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}
