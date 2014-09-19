package com.taskSell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TaskRelease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task_release", catalog = "tasksell")
public class TaskRelease implements java.io.Serializable {

	// Fields

	private String releaseId;
	private String userId;
	private String taskId;
	private String releaseInfo;
	private String releaseState;

	// Constructors

	/** default constructor */
	public TaskRelease() {
	}

	/** minimal constructor */
	public TaskRelease(String releaseId) {
		this.releaseId = releaseId;
	}

	/** full constructor */
	public TaskRelease(String releaseId, String userId, String taskId,
			String releaseInfo, String releaseState) {
		this.releaseId = releaseId;
		this.userId = userId;
		this.taskId = taskId;
		this.releaseInfo = releaseInfo;
		this.releaseState = releaseState;
	}

	// Property accessors
	@Id
	@Column(name = "release_id", unique = true, nullable = false, length = 36)
	public String getReleaseId() {
		return this.releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	@Column(name = "user_id", length = 45)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "task_id", length = 36)
	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Column(name = "release_info", length = 10)
	public String getReleaseInfo() {
		return this.releaseInfo;
	}

	public void setReleaseInfo(String releaseInfo) {
		this.releaseInfo = releaseInfo;
	}

	@Column(name = "release_state", length = 10)
	public String getReleaseState() {
		return this.releaseState;
	}

	public void setReleaseState(String releaseState) {
		this.releaseState = releaseState;
	}

}