package com.example.service;

import java.util.List;

import com.example.domain.UserDomain;


public interface UserService {
	public UserDomain findOneByUserId(int userId);
	public List<UserDomain> findAll();
	public void insertUser(UserDomain userDomain);
}
