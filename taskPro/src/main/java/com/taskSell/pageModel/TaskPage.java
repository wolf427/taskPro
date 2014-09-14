package com.taskSell.pageModel;

public class TaskPage {
	
	private String taskId;
	private String businessUserId;
	private String contact;
	private Double taskReward;
	private Double taskCost;
	private String taskType;
	private Integer confirmTime;
	private Integer deadline;
	private String taskNeed;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getBusinessUserId() {
		return businessUserId;
	}
	public void setBusinessUserId(String businessUserId) {
		this.businessUserId = businessUserId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Double getTaskReward() {
		return taskReward;
	}
	public void setTaskReward(Double taskReward) {
		this.taskReward = taskReward;
	}
	public Double getTaskCost() {
		return taskCost;
	}
	public void setTaskCost(Double taskCost) {
		this.taskCost = taskCost;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public Integer getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Integer confirmTime) {
		this.confirmTime = confirmTime;
	}
	public Integer getDeadline() {
		return deadline;
	}
	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}
	public String getTaskNeed() {
		return taskNeed;
	}
	public void setTaskNeed(String taskNeed) {
		this.taskNeed = taskNeed;
	}
	

}
