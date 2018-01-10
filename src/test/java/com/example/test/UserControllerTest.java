package com.example.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.example.controller.UserController;
import com.example.domain.UserDomain;
import com.example.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController controller;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(UserControllerTest.class);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testUserPage() throws Exception{
		UserDomain user = new UserDomain(1, "ssooni", "Ulsan");
		when(userService.findOneByUserId(1)).thenReturn(user);
 		mockMvc.perform(MockMvcRequestBuilders.get("/user/1")).andExpect(MockMvcResultMatchers.view().name("user"));
 		verify(userService).findOneByUserId(1);
 		verifyNoMoreInteractions(userService);
	}
}
