package com.wuliji.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.wuliji.domain.User;

public class PriviligeInterceptor extends MethodFilterInterceptor{

	@Override
	/**
	 * 不校验登陆和注册方法
	 */
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2.获得登陆标识
		User user = (User) session.get("user");
		//3.判断标识是否存在
		if(user != null) {
			return invocation.invoke();
		}else {
			return "toLogin";
		}
	}
	
}
