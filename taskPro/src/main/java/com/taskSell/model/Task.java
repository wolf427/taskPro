package com.taskSell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task", catalog = "tasksell")
public class Task implements java.io.Serializable {

	// Fields

	private String taskId;
	private String businessUserId;
	private String contact;
	private Double taskReward;
	private Double taskCost;
	private String taskType;
	private Integer confirmTime;
	private Integer deadline;
	private String taskNeed;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(String taskId, String businessUserId, Double taskReward) {
		this.taskId = taskId;
		this.businessUserId = businessUserId;
		this.taskReward = taskReward;
	}

	/** full constructor */
	public Task(String taskId, String businessUserId, String contact,
			Double taskReward, Double taskCost, String taskType,
			Integer confirmTime, Integer deadline, String taskNeed) {
		this.taskId = taskId;
		this.businessUserId = businessUserId;
		this.contact = contact;
		this.taskReward = taskReward;
		this.taskCost = taskCost;
		this.taskType = taskType;
		this.confirmTime = confirmTime;
		this.deadline = deadline;
		this.taskNeed = taskNeed;
	}

	// Property accessors
	@Id
	@Column(name = "task_id", unique = true, nullable = false, length = 36)
	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Column(name = "business_user_id", nullable = false, length = 36)
	public String getBusinessUserId() {
		return this.businessUserId;
	}

	public void setBusinessUserId(String businessUserId) {
		this.businessUserId = businessUserId;
	}

	@Column(name = "contact", length = 45)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "task_reward", nullable = false, precision = 22, scale = 0)
	public Double getTaskReward() {
		return this.taskReward;
	}

	public void setTaskReward(Double taskReward) {
		this.taskReward = taskReward;
	}

	@Column(name = "task_cost", precision = 22, scale = 0)
	public Double getTaskCost() {
		return this.taskCost;
	}

	public void setTaskCost(Double taskCost) {
		this.taskCost = taskCost;
	}

	@Column(name = "task_type", length = 45)
	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Column(name = "confirm_time")
	public Integer getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Integer confirmTime) {
		this.confirmTime = confirmTime;
	}

	@Column(name = "deadline")
	public Integer getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	@Column(name = "task_need", length = 500)
	public String getTaskNeed() {
		return this.taskNeed;
	}

	public void setTaskNeed(String taskNeed) {
		this.taskNeed = taskNeed;
	}

}