package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.domain.UserDomain;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDAO userDao;
	
	@Override
	public UserDomain findOneByUserId(int userId) {
		return userDao.findByUserId(userId);
	}

	@Override
	public List<UserDomain> findAll() {
		return userDao.findAll();
	}

	@Override
	public void insertUser(UserDomain userDomain) {
		userDao.insertUser(userDomain);
	}
	
}
