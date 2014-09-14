package com.taskSell.Dao.Impl;


import org.springframework.stereotype.Repository;

import com.taskSell.Dao.BusinessUserDaoI;
import com.taskSell.model.BusinessUser;
@Repository("businessDao")
public class BusinessUserDaoImpl extends BaseDaoImpl<BusinessUser> implements
		BusinessUserDaoI {

	
}
