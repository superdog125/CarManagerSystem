package com.action.login;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.login.LoginService;
import com.service.user.UserService;

public class RegisterAction extends ActionSupport implements ModelDriven<User>{
	// ��������UserΪ�˽���ǰ�˱��Ĵ�ֵ
		private User user = new User();
		
		private LoginService loginService;
		private UserService userService;
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public User getModel() {
			return user;
		}
		
		public LoginService getLoginService() {
			return loginService;
		}

		public void setLoginService(LoginService loginService) {
			this.loginService = loginService;
		}

		public UserService getUserService() {
			return userService;
		}

		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		
		public String execute(){
			System.out.println("������");
			System.out.println("���յ��û�ע�����ݣ�"+ user);
			User u = userService.QueryUserByName(user.getLoginName(),user.getLoginPwd());
			//δ�鵽��ע���û���������
			if (u == null){
				loginService.registerUser(user.getLoginName(), user.getTelephone(), user.getLoginPwd());;
				//�ж��û��Ƿ���ӵ����ݿ�
				System.out.println("loginService.registerUser����ִ�����");
				User u1 = userService.QueryUserByName(user.getLoginName(),user.getLoginPwd());
				//ע��ʧ��
				if (u1 == null){
					System.out.println("�û�ע��ʧ��");
					addActionError("�û�ע��ʧ��");
					return "input";
				}
				//ע��ɹ�
				System.out.println("�û�ע��ɹ�");
				return "success";
			//�Ѵ��ڸ��û�
			}else{
				System.out.println("���ݿ������и��û�");
				return "input";
			}

		}

	
}
