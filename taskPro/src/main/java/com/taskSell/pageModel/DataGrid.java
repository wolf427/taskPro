package com.taskSell.pageModel;

import java.util.ArrayList;
import java.util.List;

public class DataGrid {

	private int current;
	private int rowCount;
	private Long total;
	private List rows;

	public DataGrid() {
		super();
		total = 0L;
		rowCount = 0;
		current = 0;
		rows = new ArrayList();
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
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
