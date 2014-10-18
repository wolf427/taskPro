package com.taskSell.pageModel;

import java.util.Map;

public class TaskPage {
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

	private int current;
	private int rowCount;
	private Long total;
	private String sort;
	private String searchPhrase;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSearchPhrase() {
		return searchPhrase;
	}

	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}

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

	public Integer getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Integer confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getDeadline() {
		return deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	public Double getTaskCost() {
		return taskCost;
	}

	public void setTaskCost(Double taskCost) {
		this.taskCost = taskCost;
	}

	public String getTaskNeed() {
		return taskNeed;
	}

	public void setTaskNeed(String taskNeed) {
		this.taskNeed = taskNeed;
	}

	public Double getTaskReward() {
		return taskReward;
	}

	public void setTaskReward(Double taskReward) {
		this.taskReward = taskReward;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public Integer getTaskRemain() {
		return taskRemain;
	}

	public void setTaskRemain(Integer taskRemain) {
		this.taskRemain = taskRemain;
	}
}
