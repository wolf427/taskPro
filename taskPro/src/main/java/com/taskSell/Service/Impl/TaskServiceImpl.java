package com.taskSell.Service.Impl;

import java.util.UUID;

import org.apache.log4j.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskSell.Dao.TaskDaoI;
import com.taskSell.Service.TaskServiceI;
import com.taskSell.model.Task;
import com.taskSell.pageModel.TaskPage;

@Service("taskService")
public class TaskServiceImpl implements TaskServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(TaskServiceImpl.class);

	private TaskDaoI taskDao;

	public TaskDaoI getTaskDao() {
		return taskDao;
	}

	@Autowired
	public void setTaskDao(TaskDaoI taskDao) {
		this.taskDao = taskDao;
	}
	@Override
	public TaskPage save(TaskPage taskPage){
		Task task = new Task();
		BeanUtils.copyProperties(taskPage, task);
		task.setTaskId(UUID.randomUUID().toString());
		taskDao.save(task);
		return taskPage;
	}

}
