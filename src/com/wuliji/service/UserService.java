package com.wuliji.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.domain.User;
import com.wuliji.utils.PageBean;

public interface UserService {
	
	/**
	 * 登录方法
	 * @param u
	 * @return
	 */
	User findUserByCodePassword(User u);
	
	/**
	 * 注册用户
	 * @param u
	 */
	void saveUser(User u);
	
}
