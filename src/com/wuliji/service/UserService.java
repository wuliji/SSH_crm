package com.wuliji.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.User;
import com.wuliji.utils.PageBean;

public interface UserService {
	
	/**
	 * ��¼����
	 * @param u
	 * @return
	 */
	User findUserByCodePassword(User u);
	
	/**
	 * ע���û�
	 * @param u
	 */
	void saveUser(User u);
	
}
