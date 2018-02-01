package com.wuliji.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.SaleVisit;
import com.wuliji.utils.PageBean;

public interface SaleVisitService {
	
	/**
	 * ����ͻ��ݷü�¼
	 * @param saleVisit
	 */
	void save(SaleVisit saleVisit);
	
	/**
	 * ��ҳ�б�
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
