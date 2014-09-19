package com.taskSell.Service.Impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskSell.Dao.BusinessUserDaoI;
import com.taskSell.Service.BusinessUserServiceI;
import com.taskSell.model.BusinessUser;
import com.taskSell.model.User;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.UserPage;

@Service("businessUserService")
public class BusinessUserServiceImpl implements BusinessUserServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(BusinessUserServiceImpl.class);
	private BusinessUserDaoI businessUerDao;

	public BusinessUserDaoI getBusinessUerDao() {
		return businessUerDao;
	}

	@Autowired
	public void setBusinessUerDao(BusinessUserDaoI businessUerDao) {
		this.businessUerDao = businessUerDao;
	}
	@Override
	public BusinessUserPage save(BusinessUserPage businessUserPage){
		BusinessUser businessUser = new BusinessUser();
		BeanUtils.copyProperties(businessUserPage, businessUser);
		businessUser.setBusinessUserId(UUID.randomUUID().toString());
		businessUerDao.save(businessUser);
		return businessUserPage;
	}
	
	@Override
	public BusinessUser login(BusinessUserPage businessUserPage) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", businessUserPage.getUserName());
		params.put("userPwd", businessUserPage.getUserPwd());
		BusinessUser t = businessUerDao
				.get("from BusinessUser t where t.userName = :userName and t.userPwd = :userPwd",
						params);
		if (t != null) {
			return t;
		}
		return null;
	}
	
	

}
