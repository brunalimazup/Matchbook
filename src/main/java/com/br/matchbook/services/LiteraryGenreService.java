package com.br.matchbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matchbook.models.LiteraryGenre;
import com.br.matchbook.repositories.LiteraryGenreRepository;

@Service
public class LiteraryGenreService {
	@Autowired
	private LiteraryGenreRepository literaryGenreRepository;

	
	public Iterable<LiteraryGenre> showAllLiteraryGenres (){
		return literaryGenreRepository.findAll();
	}
	public String saveLiteraryGenre (LiteraryGenre literaryGenre) {
		 literaryGenreRepository.save(literaryGenre);
		 return "Gênero literario cadastrado";
	
	}
}
