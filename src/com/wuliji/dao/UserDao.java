package com.wuliji.dao;

import com.wuliji.domain.User;

public interface UserDao extends BaseDao<User>{
	
	/**
	 * 根据登录名称查询user对象
	 * @param usercode
	 * @return
	 */
	User getByUserCode(String usercode);
	
}
