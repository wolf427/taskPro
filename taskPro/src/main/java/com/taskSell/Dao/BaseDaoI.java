package com.taskSell.Dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDaoI<T> {

	public Serializable save(T t);
	public void delete(T t);
	public void update(T t);
	public void saveOrUpdate(T t);
	//查询一条记录
	public T get(String hql);
	//查询一条记录，传入id和类
	public T get(Class<T> c, Serializable id);
	//查询一条记录，传参
	public T get(String hql, Map<String, Object> params);
	//查询多条记录
	public List<T> find(String hql);
	//查询多条记录，传参
	public List<T> find(String hql, Map<String, Object> params);
	//查询多条记录，分页
	public List<T> find(String hql, int page, int rows);
	//查询多条记录，传参+分页
	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
	//记录总数
	public Long count(String hql);
	//记录总数，分页
	public Long count(String hql, Map<String, Object> params);
	//执行其他sql操作
	public int executeHql(String hql);
}
