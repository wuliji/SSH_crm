package com.wuliji.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.dao.LinkManDao;
import com.wuliji.domain.LinkMan;
import com.wuliji.service.LinkManService;
import com.wuliji.utils.PageBean;

public class LinkManServiceImpl implements LinkManService{
	
	LinkManDao lmd;
	
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.����dao��ѯ�ܼ�¼��
		Integer totalCount = lmd.findTotalCount(dc);
		//2.����PageBean����
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.����dao��ѯ��ҳ�б�
		List<LinkMan> list = lmd.findPageList(dc, pb.getStart(), pb.getPageSize());
		//4.���б����ݷ���pageBean�У�������
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);
	}

	@Override
	public LinkMan findById(Long lkm_id) {
		return lmd.findById(lkm_id);
	}
	
}
