package com.nagarro.HrMangeApplicationJenkins.controller;

import java.io.IOException;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails;


@Controller
public class EditController {

	@PostMapping("/editPage")
	public void editPageViewer(HttpServletRequest request, HttpServletResponse response) 
	{
		int id =Integer.parseInt( request.getParameter("empId"));
		request.setAttribute("empId" , id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editpage.jsp");
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
	
	
	@PostMapping("/editOperation")
	public void editData(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException
	{
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = (String) request.getParameter("empname");
		String empLoc = (String) request.getParameter("emploc");
		String empEmail = (String) request.getParameter("empemail");
		String date = (String) request.getParameter("empdob");
	    Date empDob = new SimpleDateFormat("yyyy-MM-dd").parse(date);

	    
	    
	    EmpDetails employee = new EmpDetails();
		employee.setEmpDob(empDob);
		employee.setEmpEmail(empEmail);
		employee.setEmpId(empId);
		employee.setEmpLoc(empLoc);
		employee.setEmpName(empName);
		
	    //Calling REST API for Editing Data in DB
		EditRestController editApi = new EditRestController();
		editApi.edit(employee);
		
		response.sendRedirect("fetchData");
	}
	
}

