package com.wuliji.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	
	/**
	 * 保存
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 根据对象删除
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * 根据id删除
	 * @param id
	 */
	void delete(Serializable id);
	
	/**
	 * 根据对象修改
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 根据id查对象
	 * @param id
	 * @return
	 */
	T findById(Serializable id);
	
	/**
	 * 查询符合条件的总记录数
	 * @param dc
	 * @return
	 */
	Integer findTotalCount(DetachedCriteria dc);
	
	/**
	 * 查询分页列表
	 * @param dc
	 * @param start
	 * @param pageSoze
	 * @return
	 */
	List<T> findPageList(DetachedCriteria dc, Integer start, Integer pageSoze);
	
}
