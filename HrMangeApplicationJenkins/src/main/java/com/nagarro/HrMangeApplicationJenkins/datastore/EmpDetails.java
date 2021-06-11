package com.nagarro.HrMangeApplicationJenkins.datastore;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empdetails")
public class EmpDetails {

	public EmpDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int hrId;
	@Id
	private int empId;
	private String empName;
	private String empLoc;
	private String empEmail;
	private Date empDob;
	
	
	
	
	public EmpDetails(int hrId, int empId, String empName, String empLoc, String empEmail, Date empDob) {
		super();
		this.hrId = hrId;
		this.empId = empId;
		this.empName = empName;
		this.empLoc = empLoc;
		this.empEmail = empEmail;
		this.empDob = empDob;
	}
	
	public int getHrId() {
		return hrId;
	}
	public void setHrId(int hrId) {
		this.hrId = hrId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpLoc() {
		return empLoc;
	}
	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	
	
	
}
