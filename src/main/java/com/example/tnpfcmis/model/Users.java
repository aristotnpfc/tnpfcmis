package com.example.tnpfcmis.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class Users {
	
	@Id
	private String user_id;
	
	
	private String username;
	private String password;
	private String role;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
