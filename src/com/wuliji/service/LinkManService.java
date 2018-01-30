package com.wuliji.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.LinkMan;
import com.wuliji.utils.PageBean;

public interface LinkManService {
	
	/**
	 * ������ϵ��
	 * @param linkMan
	 */
	void save(LinkMan linkMan);

	/**
	 * ��ϵ���б����
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	/**
	 * ����id���LinkMan����
	 * @param lkm_id
	 * @return
	 */
	LinkMan findById(Long lkm_id);
}
