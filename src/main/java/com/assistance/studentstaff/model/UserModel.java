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
@Table(name = "users")
@JsonInclude(value = Include.NON_NULL)
public class UserModel implements Serializable{

	private static final long serialVersionUID = 4009310373991153554L;

	@Id
	@Column(name = "USER_ID",nullable=false)
	private String userId;

	@Column(name = "USERNAME")
	@NotBlank
	private String userName;

	@Column(name = "EMAIL_ID")
	@NotBlank
	private String emailId;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE_ID")
	@NotBlank
	private String roleId;

	@Column(name = "FNAME")
	private String firstName;
	
	@Column(name = "DEPT_ID")
	private String deptId;
	
	@Column(name = "PROG_ID")
	private String progId;
	
	@Column(name = "LNAME")
	private String lastName;
	
	@Column(name = "MOBILE_NO")
	private long mobileNo;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getProgId() {
		return progId;
	}

	public void setProgId(String progId) {
		this.progId = progId;
	}

}
