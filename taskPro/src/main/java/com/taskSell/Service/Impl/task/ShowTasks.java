package com.taskSell.Service.Impl.task;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskSell.Dao.TaskDaoI;
import com.taskSell.model.Task;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.TaskPage;
@Service("showTaskService")
public class ShowTasks extends TaskServiceAdapter{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ShowTasks.class);
	
	private TaskDaoI taskDao;

	public TaskDaoI getTaskDao() {
		return taskDao;
	}

	@Autowired
	public void setTaskDao(TaskDaoI taskDao) {
		this.taskDao = taskDao;
	}
	@Override
	public DataGrid getTasks(TaskPage taskPage) {
		DataGrid datagrid = new DataGrid();
		StringBuffer hqlTemp = new StringBuffer("from Task t");
		Map<String, Object> params = new HashMap<String, Object>();
		addWhere(taskPage, hqlTemp, params);// 加where语句，筛选
		String totalHql = "select count(*)" + hqlTemp;
		addOrderBy(taskPage, hqlTemp);
		List<Task> dgTasks = taskDao.find(hqlTemp.toString(), params,
				taskPage.getCurrent(), taskPage.getRowCount());
		datagrid.setTotal(taskDao.count(totalHql, params));
		datagrid.setCurrent(taskPage.getCurrent());
		datagrid.setRowCount(taskPage.getRowCount());
		datagrid.setRows(dgTasks);
		return datagrid;
	}
	
	private void addOrderBy(TaskPage taskPage,
			StringBuffer hqlTemp) {
		if (taskPage.getSort() != null) {
			hqlTemp.append(" order by " + taskPage.getSort() + " "
					+ taskPage.getSearchPhrase());
		}
	}

	private boolean isNull(String str) {
		return (str == null || str.equals(""));
	}

	private void addWhere(TaskPage taskPage,
			StringBuffer hqlTemp, Map<String, Object> params) {
		if (isNull(taskPage.getBusinessUserId())
				&& isNull(taskPage.getTaskId())
				&& isNull(taskPage.getContact())
				&& isNull(taskPage.getTaskId())
				&& isNull(taskPage.getTaskNeed())
				&& isNull(taskPage.getTaskType())
				&& isNull(taskPage.getTaskState())) {
			return;
		}
		hqlTemp.append(" where");
		if (!isNull(taskPage.getBusinessUserId())) {
			hqlTemp.append(" t.businessUserId = :businessUserId and");
			params.put("businessUserId", taskPage.getBusinessUserId());
		}if (!isNull(taskPage.getTaskId())) {
			hqlTemp.append(" t.taskId = :taskId and");
			params.put("taskId", taskPage.getTaskId());
		}if (!isNull(taskPage.getTaskNeed())) {
			hqlTemp.append(" t.taskNeed like :taskNeed and");
			params.put("taskNeed", "%" + taskPage.getTaskNeed().trim() + "%");
		}if (!isNull(taskPage.getTaskState())) {
			hqlTemp.append(" t.taskState = :taskState and");
			params.put("taskState", taskPage.getTaskState());
		}
		hqlTemp.delete(hqlTemp.length() - 4, hqlTemp.length());
	}
}
