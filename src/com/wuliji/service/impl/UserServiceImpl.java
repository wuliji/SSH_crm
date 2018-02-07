package com.wuliji.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wuliji.dao.UserDao;
import com.wuliji.domain.Customer;
import com.wuliji.domain.User;
import com.wuliji.service.UserService;
import com.wuliji.utils.MD5Utils;
import com.wuliji.utils.PageBean;

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
		if(!existU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))) {
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
		//ʹ��MD5���߶�������м���
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		//ִ�б���
		dao.save(u);
	}
}
