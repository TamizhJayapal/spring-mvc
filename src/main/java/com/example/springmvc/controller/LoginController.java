package com.example.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(@RequestParam("name") String name, @RequestParam("password") String password) {
		
		if(loginService.isValidUser(name, password))
		return "welcome";
		
		return "login";
	}

}
