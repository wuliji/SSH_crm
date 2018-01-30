package com.wuliji.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wuliji.domain.User;
import com.wuliji.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	private UserService userService ;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		
		//1.调用Service执行
		User u = userService.findUserByCodePassword(user);
		//2.将返回的User对象放入session域中
		ActionContext.getContext().getSession().put("user", u);
		//3.重定向到首页
		return "toHome";
	}
	
	public String regist() throws Exception {
		try {
			//1.调用Service执行
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//3.重定向到首页
		return "toLogin";
	}

	@Override
	public User getModel() {
		return user;
	}
	
}
