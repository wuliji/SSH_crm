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
		
		//1.����Serviceִ��
		User u = userService.findUserByCodePassword(user);
		//2.�����ص�User�������session����
		ActionContext.getContext().getSession().put("user", u);
		//3.�ض�����ҳ
		return "toHome";
	}
	
	public String regist() throws Exception {
		try {
			//1.����Serviceִ��
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//3.�ض�����ҳ
		return "toLogin";
	}

	@Override
	public User getModel() {
		return user;
	}
	
}
