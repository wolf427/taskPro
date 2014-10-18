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
	private Integer confirmTime;
	private String contact;
	private Integer deadline;
	private Double taskCost;
	private String taskNeed;
	private Double taskReward;
	private String taskType;
	private String taskState;
	private Integer taskRemain;

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
	public Task(String taskId, String businessUserId, Integer confirmTime,
			String contact, Integer deadline, Double taskCost, String taskNeed,
			Double taskReward, String taskType, String taskState,
			Integer taskRemain) {
		this.taskId = taskId;
		this.businessUserId = businessUserId;
		this.confirmTime = confirmTime;
		this.contact = contact;
		this.deadline = deadline;
		this.taskCost = taskCost;
		this.taskNeed = taskNeed;
		this.taskReward = taskReward;
		this.taskType = taskType;
		this.taskState = taskState;
		this.taskRemain = taskRemain;
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

	@Column(name = "confirm_time")
	public Integer getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Integer confirmTime) {
		this.confirmTime = confirmTime;
	}

	@Column(name = "contact", length = 45)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "deadline")
	public Integer getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	@Column(name = "task_cost", precision = 22, scale = 0)
	public Double getTaskCost() {
		return this.taskCost;
	}

	public void setTaskCost(Double taskCost) {
		this.taskCost = taskCost;
	}

	@Column(name = "task_need")
	public String getTaskNeed() {
		return this.taskNeed;
	}

	public void setTaskNeed(String taskNeed) {
		this.taskNeed = taskNeed;
	}

	@Column(name = "task_reward", nullable = false, precision = 22, scale = 0)
	public Double getTaskReward() {
		return this.taskReward;
	}

	public void setTaskReward(Double taskReward) {
		this.taskReward = taskReward;
	}

	@Column(name = "task_type", length = 45)
	public String getTaskType() {
		return this.taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	@Column(name = "task_state", length = 10)
	public String getTaskState() {
		return this.taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	@Column(name = "task_remain")
	public Integer getTaskRemain() {
		return this.taskRemain;
	}

	public void setTaskRemain(Integer taskRemain) {
		this.taskRemain = taskRemain;
	}

}