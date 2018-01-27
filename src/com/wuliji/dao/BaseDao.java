package com.wuliji.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	
	/**
	 * ����
	 * @param t
	 */
	void save(T t);
	
	/**
	 * ���ݶ���ɾ��
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * ����idɾ��
	 * @param id
	 */
	void delete(Serializable id);
	
	/**
	 * ���ݶ����޸�
	 * @param t
	 */
	void update(T t);
	
	/**
	 * ����id�����
	 * @param id
	 * @return
	 */
	T findById(Serializable id);
	
	/**
	 * ��ѯ�����������ܼ�¼��
	 * @param dc
	 * @return
	 */
	Integer findTotalCount(DetachedCriteria dc);
	
	/**
	 * ��ѯ��ҳ�б�
	 * @param dc
	 * @param start
	 * @param pageSoze
	 * @return
	 */
	List<T> findPageList(DetachedCriteria dc, Integer start, Integer pageSoze);
	
}
