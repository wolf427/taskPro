package com.taskSell.action.task;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.taskSell.Service.TaskServiceI;
import com.taskSell.action.TaskAction;
import com.taskSell.pageModel.Json;

@ParentPackage("basePackage")
@Namespace("/")
public class ChangeTaskStateAction extends TaskAction {
	private TaskServiceI changeTaskStateService;

	public TaskServiceI getChangeTaskStateService() {
		return changeTaskStateService;
	}

	@Autowired
	public void setChangeTaskStateService(TaskServiceI changeTaskStateService) {
		this.changeTaskStateService = changeTaskStateService;
	}

	@Action(value = "approveTask")
	public void approveTask() {
		Json j = new Json();
		try {
			if (changeTaskStateService.updateTaskApprove(taskPage)) {
				j.setSuccess(true);
				j.setMsg("上线成功");
			}else{
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
		}
		super.writeJson(j);
	}
	@Action(value = "refuseTask")
	public void refuseTask() {
		Json j = new Json();
		try {
			if (changeTaskStateService.taskRefuse(taskPage)) {
				j.setSuccess(true);
				j.setMsg("拒绝成功");
			}else{
				j.setSuccess(false);
			}
		} catch (Exception e) {
			j.setSuccess(false);
		}
		super.writeJson(j);
	}
	@Action(value = "taskOff")
	public void taskOff() {
		Json j = new Json();
		String businessUserId = (String) ServletActionContext.getContext()
				.getSession().get("businessUserId");
		taskPage.setBusinessUserId(businessUserId);
		try {
			if (changeTaskStateService.taskOff(taskPage)) {
				j.setSuccess(true);
				j.setMsg("下线成功");
			}else{
				j.setSuccess(false);
			}
			
		} catch (Exception e) {
			j.setSuccess(false);
		}
		super.writeJson(j);
	}
	@Action(value = "taskOn")
	public void taskOn() {
		Json j = new Json();
		String businessUserId = (String) ServletActionContext.getContext()
				.getSession().get("businessUserId");
		taskPage.setBusinessUserId(businessUserId);
		try {
			if (changeTaskStateService.taskOff(taskPage)) {
				j.setSuccess(true);
				j.setMsg("上线成功");
			}else{
				j.setSuccess(false);
			}
			
		} catch (Exception e) {
			j.setSuccess(false);
		}
		super.writeJson(j);
	}
}
