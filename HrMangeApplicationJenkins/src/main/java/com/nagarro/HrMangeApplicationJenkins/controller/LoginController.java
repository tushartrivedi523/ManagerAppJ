package com.nagarro.HrMangeApplicationJenkins.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.HrMangeApplicationJenkins.dao.LoginDAO;
import com.nagarro.HrMangeApplicationJenkins.datastore.Hrlogin;

@Controller
public class LoginController {

	
	@RequestMapping("/")
	public String loginPageViewer()
	{
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginvalidation(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Hrlogin> credentials = LoginDAO.getCredentials((String)request.getParameter("userId"),
				  											(String)request.getParameter("password"));
		if(credentials.size() == 0)
		{
			try {
				response.sendRedirect("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else
		{
			//	Making an HttpSssion Object
			HttpSession session = request.getSession();

		for(Hrlogin login : credentials)
		{
			Cookie ck=new Cookie("name",(String)request.getParameter("userId"));  
            response.addCookie(ck);  
		session.setAttribute("name", login.getUname());
		session.setAttribute("username", login.getUserId());
		session.setAttribute("password", login.getPassword());
		session.setAttribute("hrId", login.getHrId());
		}
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
	
}


