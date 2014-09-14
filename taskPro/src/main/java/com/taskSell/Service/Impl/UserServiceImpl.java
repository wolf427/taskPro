package com.taskSell.Service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskSell.Dao.UserDaoI;
import com.taskSell.Service.UserServiceI;
import com.taskSell.model.User;
import com.taskSell.pageModel.UserPage;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	private static final Logger logger = Logger
			.getLogger(UserServiceImpl.class);

	private UserDaoI userDao;

	public UserDaoI getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(UserPage userPage) {
		User user = new User();
		BeanUtils.copyProperties(userPage, user);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", user.getUserName());
		params.put("userPwd", user.getUserPwd());
		User t = userDao
				.get("from User t where t.userName = :userName and t.userPwd = :userPwd",
						params);
		if (t != null) {
			ServletActionContext.getContext().getSession()
					.put("userId", t.getUserId());
			return user;
		}
		return null;
	}

}
