package com.action.login;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.login.LoginService;

public class RepassAction extends ActionSupport implements ModelDriven<User>{
	
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

		public String repass1() throws Exception {
			System.out.println("�������뷽��1");
			System.out.println("���յ��û���¼�ֻ��ţ�"+ user.getTelephone());
			User dbUser = loginService.confirmExistByPhone(user.getTelephone());
			System.out.println("�û�����ֻ�����֤��"+ dbUser);
			// �ж��Ƿ��ѯ�����û�
			if (dbUser == null){
				System.out.println("������֤ʧ��");
				addActionError("���û���δע��");
				return "input";
			}
			// ��֤�ɹ�����ת�������޸�ҳ��
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("repassUser", dbUser);
		    return "success";
		}
		
		
		public String repass2() throws Exception {
			System.out.println("�������뷽��2");
			System.out.println("���յ��û������޸����ݣ�"+ user);
			HttpSession session = ServletActionContext.getRequest().getSession();
			User u = (User) session.getAttribute("repassUser");
			// �õ����е�User,���ո������޸������User
			u.setLoginPwd(user.getLoginPwd());
			try{
				loginService.modifyPwd(u);
			}catch(Exception e){
				e.printStackTrace();
				return "input";
			}
			// ע��ɹ�
			// ��ȡContext�����Ķ���,����뵱ǰsession
			System.out.println("�޸�����ɹ�");
		    return "success";
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
	

}
