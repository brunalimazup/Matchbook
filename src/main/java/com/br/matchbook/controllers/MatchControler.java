package com.br.matchbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.matchbook.repositories.LiteraryGenreRepository;
import com.br.matchbook.repositories.LoginRepository;
import com.br.matchbook.repositories.UserRepository;

@Controller
public class MatchControler {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LiteraryGenreRepository literaryGenreRepository;
	
	@GetMapping("/")
	public ModelAndView displayHomePage() {
		ModelAndView modelAndView = new ModelAndView("home.html");
		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView displayLoginPage() {
		ModelAndView modelAndView = new ModelAndView("login.html");
		return modelAndView;
	}

	@GetMapping("/cadastro")
	public ModelAndView displayRegisterPage() {
		ModelAndView modelAndView = new ModelAndView("register.html");
		return modelAndView;
	}
}
