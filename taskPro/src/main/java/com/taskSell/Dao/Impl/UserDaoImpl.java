package com.taskSell.Dao.Impl;

import org.springframework.stereotype.Repository;

import com.taskSell.Dao.UserDaoI;
import com.taskSell.model.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDaoI {

}
