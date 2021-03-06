package com.taskSell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "tasksell")
public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String phoneNumber;
	private String qq;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, String userName, String userPwd) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	/** full constructor */
	public User(String userId, String userName, String userPwd, String email,
			String phoneNumber, String qq) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.qq = qq;
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false, length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_pwd", nullable = false, length = 45)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone_number", length = 20)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "qq", length = 20)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

}