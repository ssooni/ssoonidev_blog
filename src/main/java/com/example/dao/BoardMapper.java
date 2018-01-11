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
	
	@Select("SELECT * FROM board WHERE userId = #{userId}")
	public List<BoardDomain> findByUserId(@Param("userId") int userId);
	
	@Insert("INSERT INTO board VALUES(#{userId}, #{userName}, #{contents})")
	public void insert(BoardDomain board);
	
	@Update("UPDATE board SET contents=#{content} where userId=#{userId}")
	public void update(BoardDomain board);
	
	@Delete("DELETE FROM board where userId=#{userId}")
	public void delete(@Param("userId") int userId);

	public List<BoardDomain> findByUserId2(int userId);
}
