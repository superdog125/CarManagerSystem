package com.service.login;

import com.domain.User;

public interface LoginService {
	
	// ע��
	public void registerUser(String name, String phone, String password);
	
	// ��¼
	public User loginUser(String name, String password);
	
	// �޸�����
	public User confirmExistByPhone(String phone);
	
	public void modifyPwd(User user);
	
	// �˳�
	public String logoutUser();
	
}
