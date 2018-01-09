package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.UserDomain;
import com.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/user/{userId}", method=RequestMethod.GET)
	public ModelAndView showUserInfo(@PathVariable int userId) throws Exception{
		logger.info("/user/"+ userId +" called");
		UserDomain user = userService.findOneByUserId(userId);
		ModelAndView nextPage = new ModelAndView("user");
		nextPage.addObject("user", user);
		return nextPage;
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ModelAndView showUserList() throws Exception{
		logger.info("/user called");
		List<UserDomain> userList = userService.findAll();
		ModelAndView nextPage = new ModelAndView("list");
		nextPage.addObject("userList", userList);
		return nextPage;
	}
}
