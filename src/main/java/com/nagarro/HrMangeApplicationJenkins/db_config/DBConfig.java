package com.nagarro.HrMangeApplicationJenkins.db_config;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;
import com.nagarro.HrMangeApplicationJenkins.datastore.Hrlogin;


public class DBConfig {
	

	private DBConfig()
	{
		
	}
	
	public static  Session getSessionForLoginCred()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(Hrlogin.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
//		org.hibernate.Transaction tx = session.beginTransaction();
		return session;
	}
	

	
	public static Session getSessionForEmpUpload()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(EmpDetails.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
//		org.hibernate.Transaction tx = session.beginTransaction();
		return session;
	}

}