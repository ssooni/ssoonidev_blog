package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ReplyDomain;
import com.example.service.ReplyService;

@RestController
public class ReplyController {

	private Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/reply/{bno}")
	public List<ReplyDomain> findByBno(@PathVariable("bno") int bno) throws Exception{
		return replyService.findbyBno(bno);
	}
	
	@PostMapping("/reply")
	public List<ReplyDomain> insertReply(ReplyDomain reply) {
		logger.info("aaa : "  + reply.toString());
		return replyService.insert(reply);
	}
	
	@PutMapping("/reply")
	public List<ReplyDomain> updateReply(ReplyDomain reply) {
		return replyService.update(reply);
	}
	
	@PostMapping("/delete")
	public List<ReplyDomain> deleteReply(ReplyDomain reply){
		return replyService.delete(reply);
	}
	
	@GetMapping("/reply/all")
	public List<ReplyDomain> findAll(){
		return replyService.findAll();
	}
	
	@GetMapping("/reply/condition")
	public List<ReplyDomain> findByCondition(){
		return replyService.findByCondition();
	}
}
