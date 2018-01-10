package com.example.domain;

import lombok.Data;

@Data
public class UserDomain {
	
	private int userId;
	private String userName;
	private String location;

	public UserDomain() {
		
	}
	
	public UserDomain(int userId, String userName, String location) {
		this.userId = userId;
		this.userName = userName;
		this.location = location;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
