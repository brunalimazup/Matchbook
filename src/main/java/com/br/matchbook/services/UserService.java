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

	public String updateProfile(Integer id, User user) {
		userRepository.save(user);
		return "Perfil atualizado";
	}

	public void likeUser(User userLiker, Integer id) {
		User obj = userRepository.findById(userLiker.getId()).get();
		obj.getUsersLiked().add(userRepository.findById(id).get());
		userRepository.save(obj);

	}

}
