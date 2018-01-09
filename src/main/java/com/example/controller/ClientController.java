package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ClientDomain;
import com.example.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client/{userId}")
	public ClientDomain findOneByUserId(@PathVariable int userId) {
		return clientService.findOnebyUserid(userId);
	}
	
	
}
