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
@Table(name = "programs")
@JsonInclude(value = Include.NON_NULL)
public class ProgramModel implements Serializable{

	private static final long serialVersionUID = -3193954885450042473L;
	
	@Id
	@Column(name = "program_id", nullable = false)
	private String progId;

	@Column(name = "program_name", nullable = false)
	@NotBlank
	private String progName;

	@Column(name = "program_desc")
	private String progDescription;
	
	@Column(name = "dept_id", nullable = false)
	@NotBlank
	private String deptId;

	public String getProgId() {
		return progId;
	}

	public void setProgId(String progId) {
		this.progId = progId;
	}

	public String getProgName() {
		return progName;
	}

	public void setProgName(String progName) {
		this.progName = progName;
	}

	public String getProgDescription() {
		return progDescription;
	}

	public void setProgDescription(String progDescription) {
		this.progDescription = progDescription;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
