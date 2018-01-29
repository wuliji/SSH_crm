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
		//1.����dao��ѯ�ܼ�¼��
		Integer totalCount = cd.findTotalCount(dc);
		//2.����PageBean����
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.����dao��ѯ��ҳ�б�
		List<Customer> list = cd.findPageList(dc, pb.getStart(), pb.getPageSize());
		//4.���б����ݷ���pageBean�У�������
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(Customer customer) {
		//1.ά��Customer�������ֵ�Ĺ�ϵ��struts2�Ĳ�����װ�����Զ���������װ�������ֵ��idֵ
		//2.����Dao����ͻ�
		cd.saveOrUpdate(customer);
	}

	@Override
	public Customer findById(Long cust_id) {
		Customer customer = cd.findById(cust_id);
		return customer;
	}

}
