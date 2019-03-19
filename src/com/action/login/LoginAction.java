package com.action.login;

import java.util.Map;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.login.LoginService;

// 使用模型驱动的方法可以达到javabean所封装的属性与表单属性一致
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	
	private static final long serialVersionUID = 1L;
	// 这个定义的User为了接受前端表单的传值
	private User user;
	
	@Override
	public User getModel() {
		return user;
	}
	
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	} 

	public String execute() throws Exception {
		System.out.println("lalala");
		System.out.println("接收到用户登录数据："+ user);
		User dbUser = loginService.loginUser(user.getLoginName(), user.getLoginPwd());
		System.out.println("用户完成登录数据："+ dbUser);
		// 判断是否查询到该用户
		if (dbUser == null){
			System.out.println("用户登录失败");
			return "input";
		}
		// 注册成功
		// 获取Context上下文对象,添加入当前session
		Map session = ActionContext.getContext().getSession();  
		session.put("user", dbUser);
	    return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
