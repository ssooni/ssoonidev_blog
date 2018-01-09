package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="dev")
public class ClientDomain {
	
	@Id
	private String id;
	private int userId;
	private String userName;
	private String location;

}
