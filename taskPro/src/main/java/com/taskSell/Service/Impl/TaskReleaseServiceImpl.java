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
import com.taskSell.Dao.TaskReleaseDaoI;
import com.taskSell.Service.TaskReleaseServiceI;
import com.taskSell.model.Task;
import com.taskSell.model.TaskRelease;
import com.taskSell.pageModel.BusinessUserPage;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.UserPage;

/**
 * @author tanyufei
 * @data 2014-9-17
 */
/**
 * @author tanyufei
 * @data 2014-9-19
 */
@Service("taskReleaseService")
public class TaskReleaseServiceImpl implements TaskReleaseServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(TaskReleaseServiceImpl.class);

	private TaskReleaseDaoI taskReleaseDao;
	private TaskDaoI taskDao;

	public TaskDaoI getTaskDao() {
		return taskDao;
	}

	@Autowired
	public void setTaskDao(TaskDaoI taskDao) {
		this.taskDao = taskDao;
	}

	public TaskReleaseDaoI getTaskReleaseDao() {
		return taskReleaseDao;
	}

	@Autowired
	public void setTaskReleaseDao(TaskReleaseDaoI taskReleaseDao) {
		this.taskReleaseDao = taskReleaseDao;
	}

	@Override
	public TaskRelease save(TaskRelease taskRelease) {
		taskRelease.setReleaseId(UUID.randomUUID().toString());
		taskRelease.setReleaseState("init");
		taskReleaseDao.save(taskRelease);
		return taskRelease;
	}

	@Override
	public TaskRelease update(TaskRelease taskRelease) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("releaseId", taskRelease.getReleaseId());
		TaskRelease t = taskReleaseDao.get(
				"from TaskRelease tr where tr.releaseId = :releaserId", params);
		BeanUtils.copyProperties(taskRelease, t, new String[] { "releaseId",
				"userId", "taskId" });
		return t;
	}

	/**
	 * <p>
	 * Title: checkedState
	 * </p>
	 * <p>
	 * Description: business user confirm the application from user
	 * </p>
	 * 
	 * @param releaseId
	 * @return
	 */
	@Override
	public boolean checkedState(String releaseId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("releaseId", releaseId);
		TaskRelease t = taskReleaseDao.get(
				"from TaskRelease tr where tr.releaseId = :releaseId", params);
		if (t.getReleaseState().equals("init")) {
			t.setReleaseState("checked");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <p>
	 * Title: consummationState
	 * </p>
	 * <p>
	 * Description: after the user accomplish the task.he can change the state
	 * to complete
	 * </p>
	 * 
	 * @param releaseId
	 * @return
	 */
	@Override
	public boolean consummationState(String releaseId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("releaseId", releaseId);
		TaskRelease t = taskReleaseDao.get(
				"from TaskRelease tr where tr.releaseId = :releaseId", params);
		if (t.getReleaseState().equals("checked")) {
			t.setReleaseState("complete");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <p>
	 * Title: paidState
	 * </p>
	 * <p>
	 * Description: after the business user paid for the user.the task process
	 * is completed
	 * </p>
	 * 
	 * @param releaseId
	 * @return
	 */
	@Override
	public boolean paidState(String releaseId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("releaseId", releaseId);
		TaskRelease t = taskReleaseDao.get(
				"from TaskRelease tr where tr.releaseId = :releaseId", params);
		if (t.getReleaseState().equals("complete")) {
			t.setReleaseState("paid");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <p>
	 * Title: getReleases
	 * </p>
	 * <p>
	 * Description: 用户获取自己所提交的申请的方法 userId
	 * </p>
	 * 
	 * @param userPage
	 * @return
	 */
	@Override
	public DataGrid getReleases(UserPage userPage) {
		DataGrid datagrid = new DataGrid();
		StringBuffer hqlTemp = new StringBuffer("from TaskRelease t");
		Map<String, Object> params = new HashMap<String, Object>();
		addWhere(userPage, hqlTemp, params);// 加where语句，筛选
		String totalHql = "select count(*)" + hqlTemp;
		List<TaskRelease> dgTaskRelease = taskReleaseDao.find(
				hqlTemp.toString(), params, userPage.getCurrent(),
				userPage.getRowCount());
		datagrid.setCurrent(userPage.getCurrent());
		datagrid.setTotal(taskReleaseDao.count(totalHql, params));
		datagrid.setRows(dgTaskRelease);
		return datagrid;
	}
	public DataGrid getReleases(BusinessUserPage businessUserPage) {
		String hql = "from Task t where t.businessUserId=:businessUserId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("businessUserId", businessUserPage.getBusinessUserId());
		List<Task> tasks = taskDao.find(hql, params);
		DataGrid datagrid = new DataGrid();
		if(tasks==null||tasks.size()==0){
			datagrid.setRowCount(10);
			datagrid.setRows(tasks);
			datagrid.setTotal(0L);
			datagrid.setCurrent(1);
			return datagrid;
		}
		
		StringBuffer hqlTemp = new StringBuffer("from TaskRelease t");
		Map<String, Object> params1 = new HashMap<String, Object>();
		addWhere(businessUserPage, hqlTemp, params1,tasks);// 加where语句，筛选
		String totalHql = "select count(*)" + hqlTemp;
		List<TaskRelease> dgTaskRelease = taskReleaseDao.find(
				hqlTemp.toString(), params1, businessUserPage.getCurrent(),
				businessUserPage.getRowCount());
		datagrid.setCurrent(businessUserPage.getCurrent());
		datagrid.setTotal(taskReleaseDao.count(totalHql, params1));
		datagrid.setRows(dgTaskRelease);
		return datagrid;
	}

	private boolean isNull(String str) {
		return (str == null || str.equals(""));
	}
	public void addWhere(BusinessUserPage businessUserPage, StringBuffer hqlTemp,
			Map<String, Object> params,List<Task> tasks) {
		hqlTemp.append(" where");
		if (tasks!=null&&tasks.size() != 0) {
			StringBuffer taskIds = new StringBuffer();
			for (Task ta : tasks) {
				taskIds.append("'");
				taskIds.append(ta.getTaskId());
				taskIds.append("',");
			}
			taskIds.delete(taskIds.length() - 1, taskIds.length());
			hqlTemp.append(" taskId in ("+taskIds.toString()+") and");
		}
		hqlTemp.delete(hqlTemp.length() - 4, hqlTemp.length());
	}

	public void addWhere(UserPage userPage, StringBuffer hqlTemp,
			Map<String, Object> params) {
		if (isNull(userPage.getUserId()) && isNull(userPage.getTaskId())
				) {
			return;
		}
		hqlTemp.append(" where");
		if (!isNull(userPage.getUserId())) {
			hqlTemp.append(" userId=:userId and");
			params.put("userId", userPage.getUserId());
		}
		if (!isNull(userPage.getTaskId())) {
			hqlTemp.append(" taskId=:taskId and");
			params.put("taskId", userPage.getTaskId());
		}

		hqlTemp.delete(hqlTemp.length() - 4, hqlTemp.length());
	}

	/**
	 * <p>
	 * Title: bsGetReleases
	 * </p>
	 * <p>
	 * Description:商家获取自己提交的申请的方法
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public DataGrid bsGetReleases(BusinessUserPage businessUserPage) {
		return getReleases(businessUserPage);
	}
}
