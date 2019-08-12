package com.br.matchbook.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.matchbook.models.LiteraryGenre;
import com.br.matchbook.models.Login;
import com.br.matchbook.models.User;
import com.br.matchbook.models.ValidationFailures;
import com.br.matchbook.services.LiteraryGenreService;
import com.br.matchbook.services.LoginService;
import com.br.matchbook.services.UserService;

@Controller
public class MatchController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	@Autowired
	private LiteraryGenreService literaryGenreService;

	// metodos da pagina inicial

	@GetMapping("/")
	public ModelAndView displayHomePage() {
		ModelAndView modelAndView = new ModelAndView("home.html");
		return modelAndView;
	}

	// metodos da pagina de login



	// metodos da pagina de cadastro de usuarios

	@GetMapping("/cadastro")
	public ModelAndView displayRegisterPage() {
		ModelAndView modelAndView = new ModelAndView("register.html");
		modelAndView.addObject("literaryGenres", literaryGenreService.showAllLiteraryGenres());
		return modelAndView;
	}

	@PostMapping("/cadastro")
	public ModelAndView saveForm(@Valid Login login, BindingResult bindingLogin, @Valid User user,
			BindingResult bindingUser) {
		ModelAndView modelAndView = new ModelAndView("register.html");
		modelAndView.addObject("literaryGenres", literaryGenreService.showAllLiteraryGenres());
		
		if (bindingLogin.hasErrors() || bindingUser.hasErrors()) {
			List<ValidationFailures> errors = new ArrayList<ValidationFailures>();
			for (FieldError objectError : bindingLogin.getFieldErrors()) {
				errors.add(new ValidationFailures(objectError.getDefaultMessage(), objectError.getField()));
			}
			for (FieldError objectError : bindingUser.getFieldErrors()) {
				errors.add(new ValidationFailures(objectError.getDefaultMessage(), objectError.getField()));
			}
			modelAndView.addObject("validationFailures", errors);
		} else {
			loginService.registerLogin(user, login);
			modelAndView = new ModelAndView("redirect:/login");

		}

		return modelAndView;
	}


	// metodos da pagina de login
	
	@GetMapping("/login")
	public ModelAndView displayLoginPage() {
		ModelAndView modelAndView = new ModelAndView("login.html");
		return modelAndView;
	}
	@PostMapping("/login")
	public ModelAndView login(@Valid Login login, BindingResult bindingResult ,HttpSession session) {
		ModelAndView modelAndView = null;
		if (session.getAttribute("lastUrl") != null) {
			modelAndView = new ModelAndView("redirect:" + session.getAttribute("lastUrl"));
		}
		Login objectLogin = loginService.findByNickAndPass(login);
		if (objectLogin != null) {
			session.setAttribute("User", objectLogin.getUser());
			modelAndView = new ModelAndView("redirect:/perfil");
		} else {
			if (bindingResult.hasErrors()) {
				List<ValidationFailures> errors = new ArrayList<ValidationFailures>();
				for (FieldError objectError : bindingResult.getFieldErrors()) {
					errors.add(new ValidationFailures(objectError.getDefaultMessage(), objectError.getField()));
				}
				modelAndView = new ModelAndView("login.html");
				modelAndView.addObject("validationFailures", errors);
			} else {
				String error = "Senha ou Nome incorretos. Verifique se possui um cadastro.";
				modelAndView = new ModelAndView("login.html");
				modelAndView.addObject("error", error);
			}
		}
		return modelAndView;
	}

	@PostMapping("/sair")
	public ModelAndView logout(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		session.removeAttribute("User");
		return modelAndView;

	}

	// metodos da pagina de generos literarios

	@GetMapping("/cadastro/genre")
	public ModelAndView registerGenerousLiterary() {
		ModelAndView modelAndView = new ModelAndView("registerLiteraryGenre.html");
		return modelAndView;
	}

	@PostMapping("/cadastro/genre")
	public ModelAndView saveGenre(@Valid LiteraryGenre literaryGenre, BindingResult bindingGenre) {
		ModelAndView modelAndView = new ModelAndView("registerLiteraryGenre.html");

		if (bindingGenre.hasErrors()) {
			List<ValidationFailures> errors = new ArrayList<ValidationFailures>();
			for (FieldError objectError : bindingGenre.getFieldErrors()) {
				errors.add(new ValidationFailures(objectError.getDefaultMessage(), objectError.getField()));
			}
			modelAndView.addObject("validationFailures", errors);
		} else {
			literaryGenreService.saveLiteraryGenre(literaryGenre);
			modelAndView.addObject("genres", literaryGenreService.showAllLiteraryGenres());
		}

		return modelAndView;
	}

	// metodos da pagina de perfil

	@GetMapping("/perfil")
	public ModelAndView displayProfile(HttpSession session) {
		ModelAndView modelAndView = null;
		if (session.getAttribute("User") != null) {
			modelAndView = new ModelAndView("profile.html");
			User user = (User) session.getAttribute("User");
			modelAndView.addObject("user", userService.toCompareUsers(user));
		} else {
			modelAndView = new ModelAndView("redirect:/login");
		}
		return modelAndView;
	}

	@PostMapping("/perfil")
	public ModelAndView likeUser(HttpSession session, Integer id) {
		User userLiker = (User) session.getAttribute("User");
		userService.likeUser(userLiker, id);
		ModelAndView modelAndView = new ModelAndView("redirect:/perfil");
		return modelAndView;
	}
	@GetMapping("/matchs")
	public ModelAndView allUsersList (HttpSession session, Integer id) {
		ModelAndView modelAndView = null;
		if (session.getAttribute("User") != null) {
			modelAndView = new ModelAndView("matchs.html");
//			User user = (User) session.getAttribute("User");
			modelAndView.addObject("user", userService.showAllUsers());
		} else {
			modelAndView = new ModelAndView("redirect:/login");

		}
		return modelAndView;
	}

}



