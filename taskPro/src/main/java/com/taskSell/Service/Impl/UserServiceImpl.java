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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userPage.getUserName());
		params.put("userPwd", userPage.getUserPwd());
		User t = userDao
				.get("from User t where t.userName = :userName and t.userPwd = :userPwd",
						params);
		if (t != null) {
			return t;
		}
		return null;
	}

}
