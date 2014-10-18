package com.taskSell.Service.Impl.task;

import org.springframework.stereotype.Service;

import com.taskSell.model.Task;
import com.taskSell.pageModel.TaskPage;
@Service("changeTaskStateService")
public class TaskStateServiceImpl extends TaskServiceAdapter{
	@Override
	public boolean updateTaskApprove(TaskPage taskPage) {
		Task task = getTask(taskPage);
		task.setTaskState("approved_on");
		taskDao.update(task);
		return true;
	}
	@Override
	public boolean taskRefuse(TaskPage taskPage) {
		Task task = getTask(taskPage);
		task.setTaskState("refused");
		taskDao.saveOrUpdate(task);
		return true;
	}
	@Override
	public boolean taskOff(TaskPage taskPage) {
		Task task = getTask(taskPage);
		if(task==null)
			return false;
		if (task.getTaskState().equals("init")) {
			task.setTaskState("init_off");
			taskDao.update(task);
			return true;
		} else if(task.getTaskState().equals("approved_on")){
			task.setTaskState("approved_off");
			taskDao.update(task);
			return true;
		}
		return false;
	}
	@Override
	public boolean taskOn(TaskPage taskPage) {
		Task task = getTask(taskPage);
		if(task==null)
			return false;
		if (task.getTaskState().equals("init_off")) {
			task.setTaskState("init");
			taskDao.update(task);
			return true;
		} else if (task.getTaskState().equals("approved_off")){
			task.setTaskState("approved_on");
			taskDao.update(task);
			return true;
		}
		return false;
	}

}
