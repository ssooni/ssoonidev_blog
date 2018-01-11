package com.example.domain;

import lombok.Data;

@Data
public class UserDomain {
	
	private int userId;
	private String userName;
	private String location;
	private String password;
	private String role;
	
	public UserDomain() {
		
	}
	 
	public UserDomain(int userId, String userName, String location) {
		this.userId = userId;
		this.userName = userName;
		this.location = location;
	}
}
