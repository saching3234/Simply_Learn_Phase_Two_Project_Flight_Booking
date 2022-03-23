package com.services;

import com.adminbeans.AdminLogin;
import com.dao.AdminLoginDao;

public class AdminServices {
	AdminLoginDao login=new AdminLoginDao();
	

	public AdminLogin getLogin(String userName) {
		return login.getLogin(userName);
	}
	
	public boolean changePassword(String userName,String password) {
		return login.changePass(userName,password);
	}
	
	
}
