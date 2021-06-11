package com.nagarro.HrMangeApplicationJenkins.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UploadController {

	@RequestMapping(value="/uploadPage", method=RequestMethod.POST)
	public String uploadPageViewer(HttpServletRequest request, HttpServletResponse response) 
	{
		return "uploaddata";
	}
	
	@PostMapping("/uploadOperation")
	public void uploadData(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException
	{
		HttpSession session = request.getSession();
		
		
		int hrId = (Integer) session.getAttribute("hrId");
		Random rand = new Random();
		int empId = rand.nextInt(1000);
		String empName = (String) request.getParameter("empname");
		String empLoc = (String) request.getParameter("emploc");
		String empEmail = (String) request.getParameter("empemail");
		String date = (String) request.getParameter("empdob");
	    Date empDob = new SimpleDateFormat("yyyy-MM-dd").parse(date); 
	    System.out.println(empDob+" is the dob for employee "+date);
	    
	    //Calling REST API for Uploading Data to DB
	    UploadRestController uploadApi = new UploadRestController();
	    uploadApi.upload(hrId, empId, empName, empLoc, empEmail, empDob);
	    
	    response.sendRedirect("fetchData");
	}
	
	
}


