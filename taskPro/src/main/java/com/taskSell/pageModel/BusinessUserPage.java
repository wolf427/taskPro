package com.taskSell.pageModel;

public class BusinessUserPage {

	private String businessUserId;
	private String userName;
	private String userPwd;
	private String email;
	private String phoneNumber;
	private String qq;

	private String taskId;
	private String contact;
	private Double taskReward;
	private Double taskCost;
	private String taskType;
	private Integer confirmTime;
	private Integer deadline;
	private String taskNeed;
	private String taskState;
	private Integer taskRemain;

	private String releaseId;

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	private int current;
	private int rowCount;
	private Long total;
	private String sort;
	private String searchPhrase;

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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

	public String getSearchPhrase() {
		return searchPhrase;
	}

	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

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

	public String getBusinessUserId() {
		return businessUserId;
	}

	public void setBusinessUserId(String businessUserId) {
		this.businessUserId = businessUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

}
