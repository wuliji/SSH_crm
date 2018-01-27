package com.wuliji.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wuliji.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	
	private Class clazz;//用于获得运行期间泛型的类型
	
	public BaseDaoImpl() {
		//获得带有泛型类型的父类
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的发泛型类型
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = this.findById(id);
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T findById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer findTotalCount(DetachedCriteria dc) {
		//设置查询聚合函数,总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<T> findPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

}
