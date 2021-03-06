package com.taskSell.pageModel;

public class AdminPage {

	private String taskId;
	private String contact;
	private Double taskReward;
	private Double taskCost;
	private String taskType;
	private Integer confirmTime;
	private Integer deadline;
	private String taskNeed;

	private int current;
	private int rowCount;
	private Long total;
	private String sort;
	private String searchPhrase;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
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

}
