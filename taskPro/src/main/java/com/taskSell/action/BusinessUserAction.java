package com.taskSell.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.taskSell.Service.BusinessUserServiceI;
import com.taskSell.Service.TaskReleaseServiceI;
import com.taskSell.Service.TaskServiceI;
import com.taskSell.model.BusinessUser;
import com.taskSell.model.Task;
import com.taskSell.model.User;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.Json;
import com.taskSell.pageModel.UserPage;

/**
 * @author tanyufei
 * @data 2014-9-17
 */
@Namespace("/")
@Action(value = "businessUserAction")
public class BusinessUserAction extends BaseAction implements
		ModelDriven<BusinessUserPage> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(BusinessUserAction.class);

	private BusinessUserPage businessUserPage = new BusinessUserPage();
	private BusinessUserServiceI businessUserService;
	private TaskServiceI taskService;
	private TaskReleaseServiceI taskReleaseService;

	public TaskReleaseServiceI getTaskReleaseService() {
		return taskReleaseService;
	}

	@Autowired
	public void setTaskReleaseService(TaskReleaseServiceI taskReleaseService) {
		this.taskReleaseService = taskReleaseService;
	}

	public TaskServiceI getTaskService() {
		return taskService;
	}

	@Autowired
	public void setTaskService(TaskServiceI taskService) {
		this.taskService = taskService;
	}

	public BusinessUserServiceI getBusinessUserService() {
		return businessUserService;
	}

	@Autowired
	public void setBusinessUserService(BusinessUserServiceI businessUserService) {
		this.businessUserService = businessUserService;
	}

	@Override
	public BusinessUserPage getModel() {
		return businessUserPage;
	}

	public void showUsersTask() {
		String businessUserId = (String) ServletActionContext.getContext()
				.getSession().get("businessUserId");
		if (businessUserId != null) {
			businessUserPage.setBusinessUserId(businessUserId);
			super.writeJson(taskService.getTasks(businessUserPage));
		}
	}

	public void login() {
		Json j = new Json();
		BusinessUser u = businessUserService.login(businessUserPage);
		if (u != null) {
			ServletActionContext.getContext().getSession()
					.put("businessUserId", u.getBusinessUserId());
			ServletActionContext.getContext().getSession()
					.put("businessUserName", u.getUserName());
			j.setSuccess(true);
			j.setMsg("登录成功");
			j.setObj(u);
		} else {
			j.setMsg("登录失败 ");
		}
		super.writeJson(j);
	}

	public void saveTask() {
		Json j = new Json();
		try {
			Task task = new Task();
			String businessUserId = (String) ActionContext.getContext()
					.getSession().get("businessUserId");
			if (businessUserId != null) {
				BeanUtils.copyProperties(businessUserPage, task);
				task.setBusinessUserId(businessUserId);
				taskService.save(task);
				j.setSuccess(true);
				j.setMsg("保存成功");
				j.setObj(task);
				logger.info(task.getTaskNeed());
			} else {
				j.setSuccess(false);
				j.setMsg("保存失败，请登录");
				j.setObj(task);
			}
		} catch (Exception e) {
			j.setMsg("保存失败 ");
			j.setObj(e.getMessage());
		}
		super.writeJson(j);
	}

	/**
	 * <p>
	 * Title: checkByBu
	 * </p>
	 * <p>
	 * Description: 由发布者确认提交人是否有效
	 * </p>
	 */
	public void checkByBu() {
		taskReleaseService.checkedState(businessUserPage.getReleaseId());
	}

	public void getReleaseByTaskId() {
		UserPage userPage = new UserPage();
		BeanUtils.copyProperties(businessUserPage, userPage);
		super.writeJson(taskReleaseService.getReleases(userPage));
	}

	/**
	 * <p>
	 * Title: paidState
	 * </p>
	 * <p>
	 * Description: the last step of the process,business user paid for the user
	 * </p>
	 */
	public void paidState() {
		taskReleaseService.paidState(businessUserPage.getReleaseId());
	}

	/**
	 * <p>
	 * Title: showRelease
	 * </p>
	 * <p>
	 * Description: 展示该商家任务的申请情况
	 * </p>
	 */
	public void showRelease() {
		String businessUserId = (String) ActionContext.getContext()
				.getSession().get("businessUserId");
		businessUserPage.setBusinessUserId(businessUserId);
		super.writeJson(taskReleaseService.bsGetReleases(businessUserPage));
	}
	
	/**
	* <p>Title: register</p>
	* <p>Description:商家注册 </p>
	*/
	public void register(){
		Json json = new Json();
		try {
			businessUserPage=businessUserService.save(businessUserPage);
			json.setMsg("注册成功");
			json.setObj(businessUserPage);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		super.writeJson(json);
	}

}
