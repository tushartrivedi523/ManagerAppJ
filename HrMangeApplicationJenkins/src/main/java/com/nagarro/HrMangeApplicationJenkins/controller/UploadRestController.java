package com.nagarro.HrMangeApplicationJenkins.controller;
import java.util.Date;

import org.springframework.web.bind.annotation.RestController;

import com.nagarro.HrMangeApplicationJenkins.dao.UploadDataDAO;


@RestController
public class UploadRestController {

	public void upload(int hrId, int empId, String empName, String empLoc, String empEmail, Date empDob)
	{
	    UploadDataDAO.uploadData(hrId, empId, empName, empLoc, empEmail, empDob);
	}
	
}

