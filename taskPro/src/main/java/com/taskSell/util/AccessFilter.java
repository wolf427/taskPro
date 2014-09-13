package com.taskSell.util;

import org.apache.log4j.Logger;

import com.taskSell.model.User;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AccessFilter implements Filter {
	/**
	 * 防止直接在浏览器地址栏中输入jsp进行访问
	 */
	private static final Logger logger = Logger.getLogger(AccessFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(!"/Exam/".equals(request.getRequestURI())){
			if(u == null){
			response.sendRedirect("/Exam");//未登录则返回登录页
			return ;
	        } else {
	        	String role = null;
//	        	if(u.getRole().equals("管理员"))
//	        		role="admin";
//	        	if(u.getRole().equals("教师"))
//	        		role="teacher";
//	        	if(u.getRole().equals("学生"))
//	        		role="student";
//	        	switch(u.getRole()){
//	        		case "管理员":role="admin";break;
//	        		case "教师":role="teacher";break;
//	        		case "学生":role="student";break;
//	        	}
	        	if(request.getRequestURI().indexOf(role)==-1){
	            	response.sendRedirect("/Exam");//角色不符则返回登录页
	    			return ;
	        	}
	        }
		}
		filterChain.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}


}
