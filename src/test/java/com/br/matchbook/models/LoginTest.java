package com.br.matchbook.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
public class LoginTest {
private Login login;
	
	@Before
	public void preparar () {
		login = new Login();
		
	
		login.setId(null);
		login.setNickname("Robô");
		login.setEmail("Robo@zup.com.be");
		login.setPassword("123456");
	}
	@Test
	public void setNickname () {
		assertEquals("Robô", login.getNickname());
		
	}
	@Test
	public void getNickname () {
		assertEquals(login.getNickname(), "Robô");
	}
}
