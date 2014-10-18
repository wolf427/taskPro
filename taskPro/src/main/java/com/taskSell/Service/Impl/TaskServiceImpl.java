package com.taskSell.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskSell.Dao.TaskDaoI;
import com.taskSell.Service.TaskServiceI;
import com.taskSell.Service.Impl.task.TaskServiceAdapter;
import com.taskSell.model.Task;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.UserPage;

@Service("taskService")
public class TaskServiceImpl extends TaskServiceAdapter {
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
	public Task save(Task task) {
		task.setTaskId(UUID.randomUUID().toString());
		task.setTaskState("init");
		taskDao.save(task);
		return task;
	}

	@Override
	public DataGrid getTasks(BusinessUserPage businessUserPage) {
		DataGrid datagrid = new DataGrid();
		StringBuffer hqlTemp = new StringBuffer("from Task t");
		Map<String, Object> params = new HashMap<String, Object>();
		addWhere(businessUserPage, hqlTemp, params);// 加where语句，筛选
		String totalHql = "select count(*)" + hqlTemp;
		addOrderBy(businessUserPage, hqlTemp);
		List<Task> dgTasks = taskDao.find(hqlTemp.toString(), params,
				businessUserPage.getCurrent(), businessUserPage.getRowCount());
		datagrid.setTotal(taskDao.count(totalHql, params));
		datagrid.setCurrent(businessUserPage.getCurrent());
		datagrid.setRowCount(businessUserPage.getRowCount());
		datagrid.setRows(dgTasks);
		return datagrid;
	}

	private void addOrderBy(BusinessUserPage businessUserPage,
			StringBuffer hqlTemp) {
		if (businessUserPage.getSort() != null) {
			hqlTemp.append(" order by " + businessUserPage.getSort() + " "
					+ businessUserPage.getSearchPhrase());
		}
	}

	private boolean isNull(String str) {
		return (str == null || str.equals(""));
	}

	private void addWhere(BusinessUserPage businessUserPage,
			StringBuffer hqlTemp, Map<String, Object> params) {
		if (isNull(businessUserPage.getBusinessUserId())
				&& isNull(businessUserPage.getContact())
				&& isNull(businessUserPage.getTaskId())
				&& isNull(businessUserPage.getTaskNeed())
				&& isNull(businessUserPage.getTaskType())
				&& isNull(businessUserPage.getTaskState())) {
			return;
		}
		hqlTemp.append(" where");
		if (!isNull(businessUserPage.getBusinessUserId())) {
			hqlTemp.append(" t.businessUserId = :businessUserId and");
			params.put("businessUserId", businessUserPage.getBusinessUserId());
		}
		if (!isNull(businessUserPage.getTaskId())) {
			hqlTemp.append(" t.taskId = :taskId and");
			params.put("taskId", businessUserPage.getTaskId());
		}if (!isNull(businessUserPage.getTaskState())) {
			hqlTemp.append(" t.taskState = :taskState and");
			params.put("taskState", businessUserPage.getTaskState());
		}
		hqlTemp.delete(hqlTemp.length() - 4, hqlTemp.length());
	}

	@Override
	public Task getTaskById(String taskId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskId", taskId);
		return taskDao.get("from Task t where t.taskId=:taskId", params);
	}

}
