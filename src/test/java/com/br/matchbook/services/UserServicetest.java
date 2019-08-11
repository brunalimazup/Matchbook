package com.br.matchbook.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.matchbook.repositories.UserRepository;

@RunWith(SpringRunner.class)
public class UserServicetest {

	private UserService userService;
	
	private UserRepository userRepository;
	@Before
	public void prepare () {
		
		userService = new UserService();
		userService.showAllUsers();
	
	}
	@Test
	public void showAllusers () throws Exception {
		assertEquals(userService.showAllUsers(), "user");
	}
}
