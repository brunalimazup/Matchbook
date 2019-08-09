package com.br.matchbook.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.br.matchbook.controllers.MatchController;
import com.br.matchbook.models.LiteraryGenre;

@RunWith(SpringRunner.class)
public class LoginServiceTest {
	
	private LiteraryGenre loginService;
	
	@Before
	public void prepare() {
		loginService = new LiteraryGenre();
		
		loginService.setId(null);
		loginService.setName("Everton");
		
	}
	
	@Test
	public void getName()  {	
		assertEquals(loginService.getClass(), "Everton");	
	}	

}
