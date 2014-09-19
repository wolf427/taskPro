package com.taskSell.Service;

import com.taskSell.model.Task;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.UserPage;

public interface TaskServiceI {

	Task save(Task task);

	DataGrid getTasks(BusinessUserPage businessUserPage);

}
