package com.wuliji.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.SaleVisit;
import com.wuliji.utils.PageBean;

public interface SaleVisitService {
	
	/**
	 * 保存客户拜访记录
	 * @param saleVisit
	 */
	void save(SaleVisit saleVisit);
	
	/**
	 * 分页列表
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
