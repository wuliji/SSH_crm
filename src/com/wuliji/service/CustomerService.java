package com.wuliji.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.Customer;
import com.wuliji.utils.PageBean;

public interface CustomerService {

	/**
	 * ·ÖÒ³ÒµÎñ
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
