package com.example.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.dao.BoardMapper;
import com.example.domain.BoardDomain;

@RunWith(SpringRunner.class)
@MybatisTest
public class BoardMapperTest {
	
	@Autowired
	BoardMapper boardMapper;
	
	private static final int SAMPLE_USERID = 1;
	
	private static Logger logger = LoggerFactory.getLogger(BoardMapperTest.class);
	
	@Test
	public void selectTest() throws Exception{
		logger.info("Start SelectTest....");
		List<BoardDomain> resultList = boardMapper.findByUserId(SAMPLE_USERID);
		logger.info("Result List Size : " + resultList.size());

		for(BoardDomain item : resultList) {
			logger.info("userId : " + item.getUserId() + "userName : " + item.getUserName() + "contents : " + item.getContents());
		}
		logger.info("End SelectTest....");
	}	
	
}
