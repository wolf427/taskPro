package com.taskSell.Service.Impl.task;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.taskSell.Dao.TaskDaoI;
import com.taskSell.Service.TaskServiceI;
import com.taskSell.model.Task;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.TaskPage;

public class TaskServiceAdapter implements TaskServiceI{
	protected TaskDaoI taskDao;

	public TaskDaoI getTaskDao() {
		return taskDao;
	}

	@Autowired
	public void setTaskDao(TaskDaoI taskDao) {
		this.taskDao = taskDao;
	}
	@Override
	public Task save(Task task) {
		return null;
	}
	
	@Override
	public DataGrid getTasks(BusinessUserPage businessUserPage) {
		return null;
	}
	
	@Override
	public DataGrid getTasks(TaskPage taskPage) {
		return null;
	}

	@Override
	public Task getTaskById(String taskId) {
		return null;
	}
	
	public Task getTask(TaskPage taskPage){
		StringBuffer hqlTemp = new StringBuffer("from Task t where taskId=:taskId and");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskId", taskPage.getTaskId());
		if(taskPage.getBusinessUserId()!=null&&"".equals(taskPage.getBusinessUserId())){
			hqlTemp.append(" t.businessUserId = :businessUserId and");
			params.put("businessUserId", taskPage.getBusinessUserId());
		}
		if (taskPage.getTaskState()!=null&&"".equals(taskPage.getTaskState())) {
			hqlTemp.append(" t.taskState = :taskState and");
			params.put("taskState", taskPage.getTaskState());
		}
		hqlTemp.delete(hqlTemp.length() - 4, hqlTemp.length());
		return taskDao.get(hqlTemp.toString(),params);
		
	}

	@Override
	public boolean updateTaskApprove(TaskPage taskPage) {
		return true;
	}

	@Override
	public boolean taskRefuse(TaskPage taskPage) {
		return true;
	}

	@Override
	public boolean taskOff(TaskPage taskPage) {
		return true;
	}

	@Override
	public boolean taskOn(TaskPage taskPage) {
		return true;
	}

}
