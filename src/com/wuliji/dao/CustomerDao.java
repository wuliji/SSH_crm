package com.wuliji.dao;

import java.util.List;

import com.wuliji.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	
	//������ҵͳ�ƿͻ�����
	List findIndustryCount();
	
}
