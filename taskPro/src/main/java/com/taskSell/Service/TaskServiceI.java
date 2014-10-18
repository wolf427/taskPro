package com.taskSell.Service;

import com.taskSell.model.Task;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.TaskPage;
import com.taskSell.pageModel.UserPage;

public interface TaskServiceI {

	Task save(Task task);

	DataGrid getTasks(BusinessUserPage businessUserPage);

	Task getTaskById(String taskId);

	boolean updateTaskApprove(TaskPage taskPage);

	boolean taskRefuse(TaskPage taskPage);

	boolean taskOff(TaskPage taskPage);

	boolean taskOn(TaskPage taskPage);

	DataGrid getTasks(TaskPage taskPage);

}
