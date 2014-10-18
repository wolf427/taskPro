package com.taskSell.action.task;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.taskSell.Service.TaskServiceI;
import com.taskSell.action.TaskAction;

@ParentPackage("basePackage")
@Namespace("/")
public class ShowTaskAction extends TaskAction {
	private TaskServiceI showTaskService;

	public TaskServiceI getShowTaskService() {
		return showTaskService;
	}

	@Autowired
	public void setShowTaskService(TaskServiceI showTaskService) {
		this.showTaskService = showTaskService;
	}

	@Action(value = "/admin/showTaskAction")
	public void showTaskAction() {
		super.writeJson(showTaskService.getTasks(taskPage));
	}

	@Action(value = "/businessUser/showTaskAction")
	public void bsShowTaskAction() {
		String businessUserId = (String) ServletActionContext.getContext()
				.getSession().get("businessUserId");
		if (businessUserId != null) {
			taskPage.setBusinessUserId(businessUserId);
			super.writeJson(showTaskService.getTasks(taskPage));
		}
	}

}
