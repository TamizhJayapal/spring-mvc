package com.example.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "user";
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public String addUser(ModelMap model, @Valid @ModelAttribute("user") User user, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "user";
		}
		service.addUser(user.getName(), user.getEmail(), user.getCountry());
		return "redirect:show-users";
	}
	
	@RequestMapping(value="/edit-user", method=RequestMethod.GET)
	public String showEditUser(ModelMap modelMap, @RequestParam int id) {
		User user = service.getUserById(id);
		modelMap.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping(value="/edit-user", method=RequestMethod.POST)
	public String editUserSave(ModelMap model, @Valid @ModelAttribute("user") User user, 
			BindingResult result) {
		if(result.hasErrors()) return "user";
		service.updateUser(user);
		return "redirect:show-users";
	}
	
	@RequestMapping(value="/delete-user", method=RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id) {
		service.deleteUser(id);
		return "redirect:show-users";
	}
}
