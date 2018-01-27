package com.wuliji.dao;

import com.wuliji.domain.User;

public interface UserDao extends BaseDao<User>{
	
	/**
	 * ���ݵ�¼���Ʋ�ѯuser����
	 * @param usercode
	 * @return
	 */
	User getByUserCode(String usercode);
	
}
