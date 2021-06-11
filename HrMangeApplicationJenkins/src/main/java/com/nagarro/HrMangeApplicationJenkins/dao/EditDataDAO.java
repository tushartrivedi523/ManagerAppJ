package com.nagarro.HrMangeApplicationJenkins.dao;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;
import com.nagarro.HrMangeApplicationJenkins.db_config.DBConfig;

public class EditDataDAO {

	private EditDataDAO()
	{
		
	}
	public static final void editData(EmpDetails employee)
	{
		Session session = DBConfig.getSessionForEmpUpload();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query q= session.createQuery("update EmpDetails set empName=:empName, empLoc=:empLoc, empEmail=:empEmail, empDob=:empDob where empId=:empId");  
		q.setParameter("empName",employee.getEmpName());
		q.setParameter("empLoc",employee.getEmpLoc());
		q.setParameter("empEmail",employee.getEmpEmail());
		q.setParameter("empDob",employee.getEmpDob());
		q.setParameter("empId",employee.getEmpId());

		int status = q.executeUpdate();  
		System.out.println(status);  
		tx.commit();  
	}
	
}

