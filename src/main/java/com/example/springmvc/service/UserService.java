package com.example.springmvc.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.springmvc.model.User;

@Service
public class UserService {

	private static List<User> userList = new ArrayList<>();
	
	private static int count = 3;
	static {
		userList.add(new User(1, "tamizh", "tamizh@g.com", "india"));
		userList.add(new User(2, "prakash", "prakash@g.com", "india"));
		userList.add(new User(3, "ram", "ram@g.com", "US"));
	}
	
	public List<User> getAllUser(){
		return this.userList;
	}
	
	public void addUser(String name, String email, String country){
		count++;
		this.userList.add(new User(count, name, email, country));
	}
	
	public void deleteUser(int id){
		count--;
		
		Iterator iterator = this.userList.iterator();
		
		while(iterator.hasNext()) {
			User user = (User) iterator.next();
			if( user.getId() == id) {
				iterator.remove();
			}
		}
	}
}
