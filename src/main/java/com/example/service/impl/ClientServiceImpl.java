package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ClientRepo;
import com.example.domain.ClientDomain;
import com.example.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepo clientRepo;
	
	@Override
	public ClientDomain findOnebyUserid(int userId) {
		return clientRepo.findOneByUserId(userId);
	}

	@Override
	public List<ClientDomain> findAll() {
		return clientRepo.findAll();
	}
}
