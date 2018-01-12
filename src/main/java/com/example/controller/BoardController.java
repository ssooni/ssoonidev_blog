package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.BoardDomain;
import com.example.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/test")
	public ModelAndView readTest() {
		List<BoardDomain> boardList = boardService.findByBno(1);
		ModelAndView nextPage = new ModelAndView("board/readTest");
		nextPage.addObject("boardList", boardList);
		return nextPage;
	}
	
	@GetMapping("/board/{userId}")
	public ModelAndView readByuserId(@PathVariable int userId) {
		ModelAndView nextPage = new ModelAndView("board/content");
		
		return nextPage;
	}
	
}
