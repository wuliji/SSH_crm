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

	@Override
	public void save(Customer customer) {
		//1.维护Customer与数据字典的关系，struts2的参数封装，会自动将参数封装到数据字典的id值
		//2.调用Dao保存客户
		cd.saveOrUpdate(customer);
	}

	@Override
	public Customer findById(Long cust_id) {
		Customer customer = cd.findById(cust_id);
		return customer;
	}

}
