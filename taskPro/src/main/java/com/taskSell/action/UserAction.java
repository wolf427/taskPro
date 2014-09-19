package com.taskSell.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.taskSell.Service.TaskReleaseServiceI;
import com.taskSell.Service.TaskServiceI;
import com.taskSell.Service.UserServiceI;
import com.taskSell.model.TaskRelease;
import com.taskSell.model.User;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.Json;
import com.taskSell.pageModel.UserPage;

/**
 * @author tanyufei
 * @data 2014-9-19
 */
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "userAction", results = { @Result(name = "logout", location = "${pageContext.request.contextPath}", type = "redirect") })
public class UserAction extends BaseAction implements ModelDriven<UserPage> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserAction.class);
	private UserPage userPage = new UserPage();
	private UserServiceI userService;
	private TaskReleaseServiceI taskReleaseService;
	private TaskServiceI taskService;

	public TaskServiceI getTaskService() {
		return taskService;
	}

	@Autowired
	public void setTaskService(TaskServiceI taskService) {
		this.taskService = taskService;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@Override
	public UserPage getModel() {
		// TODO Auto-generated method stub
		return userPage;
	}

	public TaskReleaseServiceI getTaskReleaseService() {
		return taskReleaseService;
	}

	@Autowired
	public void setTaskReleaseService(TaskReleaseServiceI taskReleaseService) {
		this.taskReleaseService = taskReleaseService;
	}

	public void login() {
		Json j = new Json();
		User u = userService.login(userPage);
		if (u != null) {
			ServletActionContext.getContext().getSession()
					.put("userId", u.getUserId());
			ServletActionContext.getContext().getSession()
					.put("userName", u.getUserName());
			j.setSuccess(true);
			j.setMsg("登录成功");
			j.setObj(u);
		} else {
			j.setMsg("登录失败 ");
		}
		super.writeJson(j);
	}

	/**
	 * <p>
	 * Title: commitRelease
	 * </p>
	 * <p>
	 * Description: the user select a task and apply for it
	 * </p>
	 */
	public void commitRelease() {
		Json j = new Json();
		try {
			TaskRelease taskRelease = new TaskRelease();
			String userId = (String) ActionContext.getContext().getSession()
					.get("userId");
			if (userId != null) {
				BeanUtils.copyProperties(userPage, taskRelease);
				taskRelease.setUserId(userId);
				taskReleaseService.save(taskRelease);
				j.setSuccess(true);
				j.setMsg("提交成功");
				j.setObj(taskRelease);
			} else {
				j.setSuccess(false);
				j.setMsg("提交失败，请先登录");
			}
		} catch (Exception e) {
			j.setMsg("提交失败 ");
		}
		super.writeJson(j);

	}

	public void logout() {

	}

	/**
	 * <p>
	 * Title: getTaskList
	 * </p>
	 * <p>
	 * Description: at the main page,users get all the released tasks
	 * </p>
	 */
	public void getTaskList() {
		BusinessUserPage businessUserPage = new BusinessUserPage();
		BeanUtils.copyProperties(userPage, businessUserPage);
		super.writeJson(taskService.getTasks(businessUserPage));
	}
	
	/**
	* <p>Title: completeTask</p>
	* <p>Description: after users accomplish a task</p>
	*/
	public void completeTask(){
		taskReleaseService.consummationState(userPage.getReleaseId());
	}

}
