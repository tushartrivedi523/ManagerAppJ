package com.nagarro.HrMangeApplicationJenkins.dao;


import java.util.List;

import com.nagarro.HrMangeApplicationJenkins.datastore.Hrlogin;
import com.nagarro.HrMangeApplicationJenkins.db_config.DBConfig;


public class LoginDAO {

	
	private LoginDAO()
	{
		
	}
	

	@SuppressWarnings("unchecked")
	public static final List<Hrlogin> getCredentials(String userId, String password)
	{
		String hql = "from Hrlogin  WHERE userId = :userId AND password = :password";

		//Establishing Connection with DB
		org.hibernate.Query q = DBConfig.getSessionForLoginCred().createQuery(hql);
		DBConfig.getSessionForLoginCred().close();
		q.setParameter("userId", userId);
		q.setParameter("password", password);

		//Returning the list of data fetched from DB
		return q.list();
	}
	
	
}
