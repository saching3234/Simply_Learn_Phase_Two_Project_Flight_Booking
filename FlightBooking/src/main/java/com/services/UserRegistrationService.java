package com.services;
import com.adminbeans.UserRegistration;
import com.dao.UserRegistrationDao;

public class UserRegistrationService {
	UserRegistrationDao ur=new UserRegistrationDao();
	
	//returning the single login user details
	public UserRegistration getUserLogin(String userName) {
		return ur.getSingleUser(userName);
	}	
	
	public boolean registerUser(UserRegistration bean) {
	   return	ur.insertNewUser(bean);
	}	

}
