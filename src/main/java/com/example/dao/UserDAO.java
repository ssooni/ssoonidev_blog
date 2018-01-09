package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.UserDomain;

/***
 * 
 * @author ChanHoSon
 *
 */
@Mapper
public interface UserDAO {
	
	@Select("SELECT * FROM USER WHERE userId=#{userId}")
	public UserDomain findByUserId(@Param("userId") int userId);
	
	
	@Select("SELECT * FROM USER")
	public List<UserDomain> findAll();
	
	@Insert("INSERT INTO USER VALUES(#{userId}, #{userName}, #{location})")
	public void insertUser(UserDomain userDomain);
}
