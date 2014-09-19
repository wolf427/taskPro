package com.taskSell.Service;

import com.taskSell.model.BusinessUser;
import com.taskSell.pageModel.BusinessUserPage;

public interface BusinessUserServiceI {

	BusinessUserPage save(BusinessUserPage businessUserPage);

	BusinessUser login(BusinessUserPage businessUserPage);

}
