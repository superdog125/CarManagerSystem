package com.dao.login;

import com.domain.User;

public interface LoginDao{
	
	// ����һ�����û�
	public void insertUser(String name, String phone, String password);
	
	// �����û�������������û�
	public User findUserByInfo(String name, String password);
	
	// �����ֻ����޸ĸ��û�����
	public int updateUserByPhone(String phone, String password);
	
	// ����idɾ���û�
	public int deleteUserById(Integer id);

	public User findUserByPhone(String phone);

	public void insertUserByUser(User user);
}
