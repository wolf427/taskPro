package com.taskSell.action;

import org.apache.log4j.Logger;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.taskSell.Service.BusinessUserServiceI;
import com.taskSell.Service.TaskReleaseServiceI;
import com.taskSell.Service.TaskServiceI;
import com.taskSell.Service.UserServiceI;
import com.taskSell.pageModel.AdminPage;
import com.taskSell.pageModel.BusinessUserPage;

@Namespace("/")
@Action(value = "adminAction")
public class AdminAction extends BaseAction implements ModelDriven<AdminPage> {
	private static final Logger logger = Logger.getLogger(AdminAction.class);

	private AdminPage adminPage = new AdminPage();
	@Override
	public AdminPage getModel() {
		return adminPage;
	}
	
	private BusinessUserServiceI businessUserService;
	private TaskServiceI taskService;
	private TaskReleaseServiceI taskReleaseService;
	private UserServiceI userService;
	public BusinessUserServiceI getBusinessUserService() {
		return businessUserService;
	}
	@Autowired
	public void setBusinessUserService(BusinessUserServiceI businessUserService) {
		this.businessUserService = businessUserService;
	}
	public TaskServiceI getTaskService() {
		return taskService;
	}
	@Autowired
	public void setTaskService(TaskServiceI taskService) {
		this.taskService = taskService;
	}
	public TaskReleaseServiceI getTaskReleaseService() {
		return taskReleaseService;
	}
	@Autowired
	public void setTaskReleaseService(TaskReleaseServiceI taskReleaseService) {
		this.taskReleaseService = taskReleaseService;
	}
	public UserServiceI getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

}
