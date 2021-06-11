package com.nagarro.HrMangeApplicationJenkins.controller;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogoutController {

	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		 Cookie ck=new Cookie("name","");  
	        ck.setMaxAge(0);  
	        response.addCookie(ck);
	        return "index";
	}
	
}


