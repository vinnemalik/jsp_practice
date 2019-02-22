package com.cts.employeemanagementsystem.service;

import com.cts.employeemanagementsystem.dao.LoginDAO;
import com.cts.employeemanagementsystem.dao.LoginDAOImpL;

public class LoginServiceImpL implements LoginService{

	private LoginDAO dao = LoginDAOImpL.getInstance();
	
	
private static LoginServiceImpL loginServiceImpL;
	
	public static LoginServiceImpL getInstance()
	{
		if(loginServiceImpL == null)
		{
			 loginServiceImpL = new LoginServiceImpL();
			 return loginServiceImpL;
		}
		else
		{
			return loginServiceImpL;
		}
	}
	
	private LoginServiceImpL() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		return dao.getUserStatus(id);
	}

	public String getUserType(String id) {
		// TODO Auto-generated method stub
		return dao.getUserType(id);
	}

	public boolean authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(userName, password);
	}

	public String authorization(String userId) {
		// TODO Auto-generated method stub
		return dao.getUserType(userId);
	}
	

}
