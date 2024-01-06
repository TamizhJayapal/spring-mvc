package com.example.springmvc.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean isValidUser(String name, String password) {
		return name.equals("tamizh") && password.equals("123");
	}
}
