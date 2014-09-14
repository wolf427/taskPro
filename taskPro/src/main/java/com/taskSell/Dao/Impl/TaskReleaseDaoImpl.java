package com.taskSell.Dao.Impl;

import org.springframework.stereotype.Repository;

import com.taskSell.Dao.TaskReleaseDaoI;
import com.taskSell.model.TaskRelease;
@Repository("taskReleaseDao")
public class TaskReleaseDaoImpl extends BaseDaoImpl<TaskRelease> implements
		TaskReleaseDaoI {

}
