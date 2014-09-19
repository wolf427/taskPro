package com.taskSell.Service;

import com.taskSell.model.TaskRelease;
import com.taskSell.pageModel.DataGrid;
import com.taskSell.pageModel.UserPage;

public interface TaskReleaseServiceI {

	TaskRelease save(TaskRelease taskRelease);

	TaskRelease update(TaskRelease taskRelease);

	boolean checkedState(String releaseId);

	boolean consummationState(String releaseId);

	boolean paidState(String releaseId);

	DataGrid getReleases(UserPage userPage);


}
