package com.taskSell.Service;

import com.taskSell.model.User;
import com.taskSell.pageModel.UserPage;

public interface UserServiceI {

	User login(UserPage userPage);

	UserPage save(UserPage userPage);

}
