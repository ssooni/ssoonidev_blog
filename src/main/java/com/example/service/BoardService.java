package com.example.service;

import java.util.List;

import com.example.domain.BoardDomain;

public interface BoardService {

	public List<BoardDomain> findAll();
	public BoardDomain findByBno(int bno);
	public List<BoardDomain> findByBno2(int bno);
	public void insert(BoardDomain board);
	public void update(BoardDomain board);
	public void delete(int bno);

}
