package com.br.matchbook.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.matchbook.models.Erros;
import com.br.matchbook.models.LiteraryGenre;
import com.br.matchbook.models.Login;
import com.br.matchbook.models.User;
import com.br.matchbook.services.LiteraryGenreService;
import com.br.matchbook.services.LoginService;
import com.br.matchbook.services.UserService;

@Controller
public class MatchControler {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	@Autowired
	private LiteraryGenreService literaryGenreService;

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

	@GetMapping("/cadastro/genre")
	public ModelAndView registerGenerousLiterary() {
		ModelAndView modelAndView = new ModelAndView("registerLiteraryGenre.html");
		return modelAndView;	
	}
	
	
	@PostMapping("/cadastro")
	public ModelAndView saveForm(@Valid Login login, BindingResult bindingLogin, @Valid User user,
			BindingResult bindingUser) {
		ModelAndView modelAndView = new ModelAndView("register.html");

		if (bindingLogin.hasErrors() || bindingUser.hasErrors()) {
			List<Erros> erros = new ArrayList<Erros>();
			for (FieldError objectError : bindingLogin.getFieldErrors()) {
				erros.add(new Erros(objectError.getDefaultMessage(), objectError.getField()));
			}
			for (FieldError objectError : bindingUser.getFieldErrors()) {
				erros.add(new Erros(objectError.getDefaultMessage(), objectError.getField()));
			}
			System.out.println(erros);
			modelAndView.addObject("erros", erros);
		} else {
			loginService.registerLogin(user, login);
			modelAndView.addObject("logins", loginService.registerLogin(user, login));
			modelAndView.addObject("users", userService.showAllUsers());

		}

		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(Login login, HttpSession session) {
		ModelAndView modelAndView = null;
		if (session.getAttribute("lastUrl") != null) {
			modelAndView = new ModelAndView("redirect:" + session.getAttribute("lastUrl"));
		}
		Login objectLogin = loginService.findByNickAndPass(login);
		if (objectLogin != null) {
			session.setAttribute("User", objectLogin.getUser());
			String message = objectLogin.getUser().getName() + "Bem vindo.";
			modelAndView.addObject("Message", message);
		} else {
			String erro = "Senha ou nome incorretos";
			modelAndView.addObject("Message", erro);
		}
		return modelAndView;
	}

	@DeleteMapping("/login/deletar")
	public ModelAndView delete(Login login, User user) {
		ModelAndView modelAndView = new ModelAndView("login.html");
		loginService.deleteLogin(login);
		modelAndView.addObject(login);
		return modelAndView;

	}

	@PostMapping("/sair")
	public ModelAndView logout(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		session.removeAttribute("User");
		return modelAndView;

	}
	
	@PostMapping("/cadastro/genre")
	public ModelAndView saveGenre(@Valid LiteraryGenre literaryGenre, BindingResult bindingGenre) {
		ModelAndView modelAndView = new ModelAndView("registerLiteraryGenre.html");

		if (bindingGenre.hasErrors()) {
			List<Erros> erros = new ArrayList<Erros>();
			for (FieldError objectError : bindingGenre.getFieldErrors()) {
				erros.add(new Erros(objectError.getDefaultMessage(), objectError.getField()));
			}
			System.out.println(erros);
			modelAndView.addObject("erros", erros);
		} else {
			literaryGenreService.saveLiteraryGenre(literaryGenre);
			modelAndView.addObject("genres", literaryGenreService.showAllLiteraryGenres());
			

		}
		return modelAndView;

	
}
}