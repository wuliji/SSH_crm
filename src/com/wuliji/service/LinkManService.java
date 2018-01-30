package com.wuliji.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.LinkMan;
import com.wuliji.utils.PageBean;

public interface LinkManService {
	
	/**
	 * 保存联系人
	 * @param linkMan
	 */
	void save(LinkMan linkMan);

	/**
	 * 联系人列表对象
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	/**
	 * 根据id获得LinkMan对象
	 * @param lkm_id
	 * @return
	 */
	LinkMan findById(Long lkm_id);
}
