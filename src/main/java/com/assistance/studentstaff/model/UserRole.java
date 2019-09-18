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
@Table(name = "user_roles")
@JsonInclude(value = Include.NON_NULL)
public class UserRole implements Serializable{
	
	private static final long serialVersionUID = 748361253084242812L;

	@Id
	@Column(name = "ROLE_ID",nullable=false)
	private String roleId;

	@Column(name = "TYPE")
	@NotBlank
	private String type;

	@Column(name = "DESCRIPTION")
	private String description;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
