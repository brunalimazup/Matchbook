package com.br.matchbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matchbook.models.User;
import com.br.matchbook.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	

	public Iterable<User> showAllUsers() {
		return userRepository.findAll();
	}
}
