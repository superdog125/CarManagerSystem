package com.action.login;

import java.util.Map;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.login.LoginService;

// ʹ��ģ�������ķ������Դﵽjavabean����װ�������������һ��
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	
	private static final long serialVersionUID = 1L;
	// ��������UserΪ�˽���ǰ�˱��Ĵ�ֵ
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
		System.out.println("���յ��û���¼���ݣ�"+ user);
		User dbUser = loginService.loginUser(user.getLoginName(), user.getLoginPwd());
		System.out.println("�û���ɵ�¼���ݣ�"+ dbUser);
		// �ж��Ƿ��ѯ�����û�
		if (dbUser == null){
			System.out.println("�û���¼ʧ��");
			return "input";
		}
		// ע��ɹ�
		// ��ȡContext�����Ķ���,����뵱ǰsession
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
