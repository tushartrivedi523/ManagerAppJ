package com.nagarro.HrMangeApplicationJenkins.dao;


import java.util.Date;

import org.hibernate.Session;

import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;
import com.nagarro.HrMangeApplicationJenkins.db_config.DBConfig;
public class UploadDataDAO {

	private UploadDataDAO()
	{
		
	}
	public static final void uploadData(int hrId, int empId, String empName, String empLoc, String empEmail, Date empDob)
	{
		
		Session session = DBConfig.getSessionForEmpUpload();
		org.hibernate.Transaction tx = session.beginTransaction();
		
		
		EmpDetails employee = new EmpDetails(hrId, empId, empName, empLoc, empEmail, empDob);
		session.saveOrUpdate(employee);
		tx.commit();
		session.close();
		

	}
	
}
