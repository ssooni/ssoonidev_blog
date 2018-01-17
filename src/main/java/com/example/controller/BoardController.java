package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.BoardDomain;
import com.example.service.BoardService;

@Controller
public class BoardController {

	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	
	// 전체 보기
	@GetMapping("/board")
	public ModelAndView list() throws Exception{
		List<BoardDomain> boardList = boardService.findAll();
		ModelAndView nextPage = new ModelAndView("board/home");
		nextPage.addObject("boardList", boardList);
		return nextPage;
	}

	// 새 글 올리기
	@PostMapping("/board")
	public void create(BoardDomain board) throws Exception{
		logger.info("POST /board : " + board.toString());
		boardService.insert(board);
	}
	
	// 글 수정
	@PutMapping("/board")
	public void modify(BoardDomain board) throws Exception{
		logger.info("PUT data : " + board.toString());
		boardService.update(board);
	}

	// 글 상세보기
	@GetMapping("/board/{bno}")
	public ModelAndView readOne(@PathVariable("bno") int bno) throws Exception{
		ModelAndView popupPage = new ModelAndView("board/read");
		popupPage.addObject("board", boardService.findByBno(bno));
		return popupPage;
	}

	// 글 삭제
	@DeleteMapping("/board/{bno}")
	public void delete(@PathVariable("bno") int bno) throws Exception{
		logger.info("DELETE bno : " + bno);
		boardService.delete(bno);
	}
	
	// TEST
	@GetMapping("/test")
	public ModelAndView readTest() throws Exception{
		BoardDomain boardList = boardService.findByBno(1);
		ModelAndView nextPage = new ModelAndView("board/home");
		nextPage.addObject("boardList", boardList);
		return nextPage;
	}
}
