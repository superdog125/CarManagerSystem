package com.dao.impl.login;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.login.LoginDao;
import com.domain.User;

@Repository
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {

	@Override
	public void insertUser(String name, String phone, String password) {
		User user = new User();
		user.setLoginName(name);
		user.setTelephone(phone);
		user.setLoginPwd(password);
		System.out.println("即将保存的用户:" + user);
		this.getHibernateTemplate().save(user);
	}

//	${pageContext.request.contextPath}
	@Override
	public User findUserByInfo(String name, String password) {
		ArrayList<User> userlist = new ArrayList<User>();
		userlist = (ArrayList<User>) this.getHibernateTemplate().find("from User where aname=? and apassword=?", name, password);
		return userlist.get(0);
	}

	@Override
	public int updateUserByPhone(String phone, String password) {
		return 0;
	}

	@Override
	public int deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUserByPhone(String phone) {
		ArrayList<User> userlist = new ArrayList<User>();
		userlist = (ArrayList<User>) this.getHibernateTemplate().find("from User where aphone=?", phone);
		return userlist.get(0);
	}

	@Override
	public void insertUserByUser(User user) {
		Serializable result = this.getHibernateTemplate().save(user);
		if (result!=null){
			System.out.println("Dao层用户信息保存成功");
		}else{
			System.out.println("Dao层用户信息保存失败");
		}
	}

}
