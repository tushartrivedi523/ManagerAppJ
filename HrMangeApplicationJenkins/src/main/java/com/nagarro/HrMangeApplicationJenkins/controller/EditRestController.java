package com.nagarro.HrMangeApplicationJenkins.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.HrMangeApplicationJenkins.dao.EditDataDAO;
import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;

@RestController
public class EditRestController {

	public void edit(EmpDetails employee)
	{
		EditDataDAO.editData(employee);
	}
	
}
