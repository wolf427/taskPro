package com.taskSell.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.taskSell.Service.TaskServiceI;
import com.taskSell.pageModel.TaskPage;

public class TaskAction extends BaseAction implements ModelDriven<TaskPage> {

	protected TaskPage taskPage = new TaskPage();
	protected TaskServiceI taskService;

	public TaskServiceI getTaskService() {
		return taskService;
	}

	@Autowired
	public void setTaskService(TaskServiceI taskService) {
		this.taskService = taskService;
	}

	@Override
	public TaskPage getModel() {
		return taskPage;
	}
	
	

}
