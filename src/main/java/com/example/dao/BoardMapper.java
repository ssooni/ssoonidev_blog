package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.BoardDomain;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT * FROM board")
	public List<BoardDomain> findAll();
	
	@Select("SELECT * FROM board WHERE userName=#{userName}")
	public List<BoardDomain> findByUserName(@Param("userName") String userName);
	
	@Select("SELECT * FROM board WHERE bno = #{bno}")
	public BoardDomain findByBno(@Param("bno") int bno);
	
	@Insert("INSERT INTO board(userName, contents) VALUES(#{userName}, #{contents})")
	public void insert(BoardDomain board);
	
	@Update("UPDATE board SET contents=#{contents} where bno=#{bno}")
	public void update(BoardDomain board);
	
	@Delete("DELETE FROM board where bno=#{bno}")
	public void delete(@Param("bno") int bno);

	public List<BoardDomain> findByBno2(int bno);
}
