package com.wuliji.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.dao.CustomerDao;
import com.wuliji.domain.Customer;
import com.wuliji.service.CustomerService;
import com.wuliji.utils.PageBean;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao cd;
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用dao查询总记录数
		Integer totalCount = cd.findTotalCount(dc);
		//2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.调用dao查询分页列表
		List<Customer> list = cd.findPageList(dc, pb.getStart(), pb.getPageSize());
		//4.将列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}

}
