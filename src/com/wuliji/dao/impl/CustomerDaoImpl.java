package com.wuliji.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.wuliji.dao.CustomerDao;
import com.wuliji.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	@Override
	@SuppressWarnings("all")
	public List<Object[]> findIndustryCount() {
		//‘≠…˘SQL≤È—Ø
		String sql = "select bd.dict_item_name,count(*) total from cst_customer c,base_dict bd where c.cust_industry = bd.dict_id group by c.cust_industry";
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		return list;
	}

}
