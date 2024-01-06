package com.example.springmvc.model;

import java.util.Objects;

public class User {

	private int id;
	
	private String name;
	
	private String email;
	
	private String country;
	
	
	public User() {
	}


	public User(int id, String name, String email, String country) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, email, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(country, other.country) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + "]";
	}
	
}