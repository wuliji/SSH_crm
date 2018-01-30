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
		//1.根据登录名称查询登陆用户
		User existU = dao.getByUserCode(u.getUser_code());
		//2.判断用户是否存在，不存在则抛出异常
		if(existU == null) {
			throw new RuntimeException("用户名不存在");
		}
		//3.判断用户密码
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		//4.返回查询到的用户对象
		return existU;
	}

	@Override
	public void saveUser(User u) {
		//1.调用dao 根据注册登录名获得用户对象查重
		User existU = dao.getByUserCode(u.getUser_code());
		if(existU != null) {
			throw new RuntimeException("用户名已经存在");
		}
		//执行保存
		dao.save(u);
	}

}
