package com.taskSell.Service.Impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskSell.Dao.TaskReleaseDaoI;
import com.taskSell.Service.TaskReleaseServiceI;
import com.taskSell.model.Task;
import com.taskSell.model.TaskRelease;
import com.taskSell.pageModel.TaskReleasePage;
@Service("taskReleaseService")
public class TaskReleaseServiceImpl implements TaskReleaseServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(TaskReleaseServiceImpl.class);
	
	private TaskReleaseDaoI taskReleaseDao;
	
	
	public TaskReleaseDaoI getTaskReleaseDao() {
		return taskReleaseDao;
	}

@Autowired
	public void setTaskReleaseDao(TaskReleaseDaoI taskReleaseDao) {
		this.taskReleaseDao = taskReleaseDao;
	}


	public TaskReleasePage save(TaskReleasePage taskReleasePage){
		TaskRelease taskRelease = new TaskRelease();
		BeanUtils.copyProperties(taskReleasePage, taskRelease);
		taskRelease.setReleaseId(UUID.randomUUID().toString());
		taskReleaseDao.save(taskRelease);
		return taskReleasePage;
	}
	
	public TaskReleasePage update(TaskReleasePage taskReleasePage){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("releaseId", taskReleasePage.getReleaseId());
		TaskRelease taskRelease = taskReleaseDao.get("from TaskRelease tr where tr.releaseId = :releaserId",params);
		BeanUtils.copyProperties(taskReleasePage, taskRelease,new String[]{"releaseId","userId","taskId"});
		return taskReleasePage;
	}

}
