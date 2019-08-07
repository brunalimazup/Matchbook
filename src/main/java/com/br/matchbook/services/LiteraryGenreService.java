package com.br.matchbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matchbook.models.LiteraryGenre;
import com.br.matchbook.repositories.LiteraryGenreRepository;
import com.br.matchbook.repositories.UserRepository;

@Service
public class LiteraryGenreService {
	@Autowired
	private LiteraryGenreRepository literaryGenreRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Iterable<LiteraryGenre> showAllLiteraryGenres (){
		return literaryGenreRepository.findAll();
	}
	
}
