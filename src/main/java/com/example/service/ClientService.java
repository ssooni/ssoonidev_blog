package com.example.service;

import java.util.List;

import com.example.domain.ClientDomain;

public interface ClientService {
	public ClientDomain findOnebyUserid(int userId);
	public List<ClientDomain> findAll();
}
