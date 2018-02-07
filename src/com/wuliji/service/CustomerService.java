package com.wuliji.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.Customer;
import com.wuliji.utils.PageBean;

public interface CustomerService {

	/**
	 * 分页业务
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	/**
	 * 保存客户
	 * @param customer
	 */
	void save(Customer customer);
	
	/**
	 * 根据id获得客户对象
	 * @param cust_id
	 * @return
	 */
	Customer findById(Long cust_id);
	
	/**
	 * 客户统计
	 * @return
	 */
	List<Object[]> getIndustry();

}
