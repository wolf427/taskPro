package com.taskSell.Dao.Impl;

import org.springframework.stereotype.Repository;

import com.taskSell.Dao.TaskDaoI;
import com.taskSell.model.Task;
@Repository("taskDao")
public class TaskDaoImpl extends BaseDaoImpl<Task> implements TaskDaoI {

}
