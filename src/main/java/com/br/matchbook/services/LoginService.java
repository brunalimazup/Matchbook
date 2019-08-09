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
		
		if(loginRepository.existsByNickname(login.getNickname())) {
			return "NickName já existe. Escolha outro"; 
		}
		login.setUser(user);
		loginRepository.save(login);
		return "Login cadastrado com sucesso";
	}
	
	public void updateLogin (Login login) {
		loginRepository.save(login);
	}
	
	public void deleteLogin(Login login) {
		loginRepository.delete(login);
	}	
	
	public Login findByNickAndPass(Login login) {
		Login obj = null;
		try {
			obj = loginRepository.findByNicknameAndPassword(login.getNickname(), login.getPassword()).get();
			return obj;
		} catch (Exception e) {
			return obj;
		}
		
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
