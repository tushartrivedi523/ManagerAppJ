package com.nagarro.HrMangeApplicationJenkins.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.HrMangeApplicationJenkins.dao.RetriveDataDAO;
import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;

@RestController
public class RetreiveRestController {

	public List<EmpDetails> get(int hrId)
	{
		List<EmpDetails> employeesData = RetriveDataDAO.retriveData(hrId);
		return employeesData;
	}
	
	
	
//	@GetMapping("/home")
//	public List<EmpDetails> get()
//	{
//		List<EmpDetails> employeesData = RetriveDataDAO.retriveData1();
//		return employeesData;
//	}
	
}



