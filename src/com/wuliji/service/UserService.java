package com.wuliji.service;

import com.wuliji.domain.User;

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
