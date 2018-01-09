package com.example.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.ClientDomain;

public interface ClientRepo extends MongoRepository<ClientDomain, Long>{
	public ClientDomain findOneByUserId(int userId);
	public List<ClientDomain> findAll();
}
