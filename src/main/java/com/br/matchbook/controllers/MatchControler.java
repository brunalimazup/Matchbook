package com.br.matchbook.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.matchbook.models.Login;
import com.br.matchbook.models.User;
import com.br.matchbook.services.LoginService;
import com.br.matchbook.services.UserService;

@Controller
public class MatchControler {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

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

	@GetMapping("/generos")
	public ModelAndView registerGenerousLiterary() {
		ModelAndView modelAndView = new ModelAndView("genre.html");
		return modelAndView;	
	}
	
	
	@PostMapping("/cadastro")
	public ModelAndView saveForm(@Valid Login login, BindingResult bindingLogin, @Valid User user,
			BindingResult bindingUser) {
		ModelAndView modelAndView = new ModelAndView("register.html");

		if (bindingLogin.hasErrors() || bindingUser.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			for (ObjectError objectError : bindingLogin.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
				modelAndView.addObject("login", loginService);
				modelAndView.addObject("erros", erros);
			}
			for (ObjectError objectError : bindingUser.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
				modelAndView.addObject("user", userService);
				modelAndView.addObject("erros", erros);
			}
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
}
