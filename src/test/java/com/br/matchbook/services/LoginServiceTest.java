package com.br.matchbook.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.matchbook.models.Login;

@RunWith(SpringRunner.class)
public class LoginServiceTest {
	
	private LoginService loginService;
	
	private Login login;
	
	@Before
	public void prepare() {
		login = new Login();
		
		
		login.setId(null);
		login.setNickname("Everton");
		login.setPassword("123456");
		login.setEmail("everton@everton.com");
		
	}
	
	@Test
	public void getName()  {	
		assertEquals(login.getNickname(), "Everton");	
	}	

}
