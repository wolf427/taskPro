package com.taskSell.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.taskSell.Service.UserServiceI;
import com.taskSell.model.User;
import com.taskSell.pageModel.Json;
import com.taskSell.pageModel.UserPage;

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
	
	public void login(){
		Json j = new Json();
		User u = userService.login(userPage);
		if (u != null) {
			ActionContext.getContext().getSession().put("user", userPage);
			j.setSuccess(true);
			j.setMsg("登录成功");
			j.setObj(u);
		} else {
			j.setMsg("登录失败 ");
		}
		super.writeJson(j);
	}
	
	public void logout(){
		
	}

}
