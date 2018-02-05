package com.wuliji.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.dao.SaleVisitDao;
import com.wuliji.domain.Customer;
import com.wuliji.domain.SaleVisit;
import com.wuliji.service.SaleVisitService;
import com.wuliji.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService{

	private SaleVisitDao svd;
	
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

	@Override
	public void save(SaleVisit saleVisit) {
		svd.saveOrUpdate(saleVisit);
	}
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用dao查询总记录数
		Integer totalCount = svd.findTotalCount(dc);
		//2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.调用dao查询分页列表
		List<SaleVisit> list = svd.findPageList(dc, pb.getStart(), pb.getPageSize());
		//4.将列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}

	@Override
	public SaleVisit findById(String visit_id) {
		SaleVisit saleVisit = svd.findById(visit_id);
		return saleVisit;
	}

}
