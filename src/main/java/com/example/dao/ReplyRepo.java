package com.example.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.domain.ReplyDomain;

public interface ReplyRepo extends MongoRepository<ReplyDomain, Long>{
	public List<ReplyDomain> findByBno(int bno);
	public List<ReplyDomain> findAll();
}
