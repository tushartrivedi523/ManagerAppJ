package com.nagarro.HrMangeApplicationJenkins.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;

@Controller
public class DisplayDataController {

	@GetMapping("/fetchData")
	public void fetchData(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		int hrId = (Integer) session.getAttribute("hrId");
		
	    //Calling REST API for Fetching Data from DB
		RetreiveRestController getApi = new RetreiveRestController();
		List<EmpDetails> employeesData = getApi.get(hrId);
		
		request.setAttribute("employees", employeesData);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp");  
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
