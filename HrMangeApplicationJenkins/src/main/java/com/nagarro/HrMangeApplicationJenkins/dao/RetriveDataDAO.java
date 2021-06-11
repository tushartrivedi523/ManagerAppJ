package com.nagarro.HrMangeApplicationJenkins.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;
import com.nagarro.HrMangeApplicationJenkins.db_config.DBConfig;
public class RetriveDataDAO {

	private RetriveDataDAO()
	{
		
	}
	@SuppressWarnings("unchecked")
	public static final List<EmpDetails> retriveData(int hrId)
	{
		Session session = DBConfig.getSessionForEmpUpload();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		String hql = "from EmpDetails WHERE hrId = :hrId";
		Query query = session.createQuery(hql);
		query.setParameter("hrId", hrId);
		return query.list();
	}
	
//	@SuppressWarnings("unchecked")
//	public static final List<EmpDetails> retriveData1()
//	{
//		Session session = DBConfig.getSessionForEmpUpload();
//		org.hibernate.Transaction tx = session.beginTransaction();
//		
//		String hql = "from EmpDetails";
//		Query query = session.createQuery(hql);
////		query.setParameter("hrId", hrId);
//		return query.list();
//	}
	
}
