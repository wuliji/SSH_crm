package com.wuliji.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wuliji.dao.BaseDictDao;
import com.wuliji.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao{

	@Override
	public List<BaseDict> findListByTypeCode(String dict_type_code) {
		//Criteria
		//�������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//��װ����
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//ִ�в�ѯ
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	
}
