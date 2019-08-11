package com.br.matchbook.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.thymeleaf.Thymeleaf;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.br.matchbook.models.LiteraryGenre;
import com.br.matchbook.models.Login;
import com.br.matchbook.models.User;
import com.br.matchbook.services.LiteraryGenreService;
import com.br.matchbook.services.LoginService;
import com.br.matchbook.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(MatchController.class)
public class MatchControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;
	@MockBean
	private LoginService loginService;
	@MockBean
	private LiteraryGenreService literaryGenreService;
	
	private User user;
	private Login login;
	private LiteraryGenre literaryGenre;
	@Before
	public void prepare () throws Exception{
		login = new Login ();
		login.setId(null);
		login.setNickname("Lula");
		login.setPassword("123456");
		login.setEmail("lulalivre@pete.com");
		login.setUser(user);
		
		user = new User();
		user.setId(null);
		user.setName("José");
		user.setLastName("zé");
		user.setAge(75);
		user.setGender("masculino");
		user.setCity("São Paulo");
		user.setLiteraryGenre(null);
		user.setUsersLiked(null);
		
		literaryGenre = new LiteraryGenre();
		literaryGenre.setId(null);
		literaryGenre.setName("Terror");
		literaryGenre.setUsers(null);
		
	}
	@Test
	public void saveForm() throws Exception {
		login.setId(1);
		given(loginService.registerLogin(user, login)).willReturn("user");
	}
}

















