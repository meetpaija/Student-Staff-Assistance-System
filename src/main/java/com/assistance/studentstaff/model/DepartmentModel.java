package com.assistance.studentstaff.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "departments")
@JsonInclude(value = Include.NON_NULL)
public class DepartmentModel implements Serializable{

	private static final long serialVersionUID = -3193954885450042473L;
	
	@Id
	@Column(name = "dept_id", nullable = false)
	private String deptId;

	@Column(name = "dept_name", nullable = false)
	@NotBlank
	private String deptName;

	@Column(name = "dept_desc")
	private String deptDescription;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDescription() {
		return deptDescription;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

}
