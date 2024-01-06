package com.example.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvc.model.User;
import com.example.springmvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@RequestMapping(value="/show-users", method=RequestMethod.GET)
	public String showUser(ModelMap modelMap) {
		
		List<User> userList = service.getAllUser();
		modelMap.put("users", userList);
		return "show-users";
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.GET)
	public String addUser() {
		return "add-user";
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public String postUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("country") String country) {
		service.addUser(name, email, country);
		return "redirect:show-users";
	}
	
	@RequestMapping(value="/delete-user", method=RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id) {
		service.deleteUser(id);
		return "redirect:show-users";
	}
}
