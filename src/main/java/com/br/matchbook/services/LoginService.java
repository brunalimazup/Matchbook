package com.br.matchbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matchbook.models.Login;
import com.br.matchbook.models.User;
import com.br.matchbook.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public String registerLogin (User user, Login login) {
		login.setUser(user);
		loginRepository.save(login);
		return "Login cadastrado";
	}
	
	public void updateLogin (Login login) {
		loginRepository.save(login);
	}
	
	public void deleteLogin(Login login) {
		loginRepository.delete(login);
	}	
	
	public Login findByNickAndPass(Login login) {

		return loginRepository.findByNicknameAndPassword(login.getNickname(), login.getPassword()).get();
	}
}
