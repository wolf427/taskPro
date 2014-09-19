package com.taskSell.pageModel;

import java.util.ArrayList;
import java.util.List;

public class DataGrid {

	private Long total;
	private List rows;

	public DataGrid() {
		super();
		total = 0L;
		rows = new ArrayList();
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
