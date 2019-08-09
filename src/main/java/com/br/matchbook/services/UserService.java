package com.br.matchbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matchbook.models.User;
import com.br.matchbook.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> showAllUsers() {
		Iterable<User> allUsersBank = userRepository.findAll();	
		List<User> allUsersList = new ArrayList<User>();
		for (User user : allUsersBank) {
			allUsersList.add(user);
		}
		
		return allUsersList;
	}
	public Iterable<User> toCompareUsers (User user) {
		List<User> allUsers = showAllUsers();
		List<User> listUser = user.getUsersLiked();
		for (User especificUser : listUser) {
			if(allUsers.contains(especificUser)) {
				allUsers.remove(especificUser);
			}
		}
		return allUsers;

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
