package com.wuliji.service;

import com.wuliji.domain.User;

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
