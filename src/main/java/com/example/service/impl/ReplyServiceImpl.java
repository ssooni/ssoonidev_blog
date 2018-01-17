package com.example.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.dao.ReplyRepo;
import com.example.domain.ReplyDomain;
import com.example.service.ReplyService;
import com.mongodb.WriteResult;

@Service
public class ReplyServiceImpl implements ReplyService{

	private static Logger logger = LoggerFactory.getLogger(ReplyService.class);
	
	@Autowired
	private ReplyRepo replyRepo;
	
	@Autowired
	private MongoTemplate mongoTemplete;
		
	@Cacheable(value="replyCache", key="#bno")
	@Override
	public List<ReplyDomain> findbyBno(int bno) {
		return replyRepo.findByBno(bno);
	}
	
	@CachePut(value="replyCache", key="#reply.bno")
	@Override
	public List<ReplyDomain> insert(ReplyDomain reply) {
		int bno = reply.getBno();	
		mongoTemplete.insert(reply);
		return replyRepo.findByBno(bno);
	}

	@CachePut(value = "replyCache", key="#result.id")
	@Override
	public List<ReplyDomain> update(ReplyDomain reply) {
		int bno = reply.getBno();
		
		ObjectId id = new ObjectId(reply.getId());
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		Update update = new Update();
		update.set("userName", reply.getUserName());
		update.set("contents", reply.getContents());
		
		WriteResult writeResult = mongoTemplete.updateFirst(query, update, ReplyDomain.class);
		logger.info(writeResult.toString());
				
		return replyRepo.findByBno(bno);
	}
	@CacheEvict(value = "replyCache", key="")
	@Override
	public List<ReplyDomain> delete(ReplyDomain reply) {
		int bno = reply.getBno();
		
		ObjectId id = new ObjectId(reply.getId());

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		mongoTemplete.remove(query, ReplyDomain.class);
		
		return replyRepo.findByBno(bno);		
	}

	@Override
	public List<ReplyDomain> findAll() {
		return replyRepo.findAll();
	}

	@Override
	public List<ReplyDomain> findByCondition() {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").gt(10));
		return mongoTemplete.find(query, ReplyDomain.class);
	}
}
