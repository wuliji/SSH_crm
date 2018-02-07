package com.wuliji.dao;

import java.util.List;

import com.wuliji.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	
	//按照行业统计客户数量
	List findIndustryCount();
	
}
