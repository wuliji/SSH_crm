package com.wuliji.service.impl;

import com.wuliji.dao.UserDao;
import com.wuliji.domain.User;
import com.wuliji.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User findUserByCodePassword(User u) {
		//1.���ݵ�¼���Ʋ�ѯ��½�û�
		User existU = dao.getByUserCode(u.getUser_code());
		//2.�ж��û��Ƿ���ڣ����������׳��쳣
		if(existU == null) {
			throw new RuntimeException("�û���������");
		}
		//3.�ж��û�����
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("�������");
		}
		//4.���ز�ѯ�����û�����
		return existU;
	}

	@Override
	public void saveUser(User u) {
		//1.����dao ����ע���¼������û��������
		User existU = dao.getByUserCode(u.getUser_code());
		if(existU != null) {
			throw new RuntimeException("�û����Ѿ�����");
		}
		//ִ�б���
		dao.save(u);
	}

}
