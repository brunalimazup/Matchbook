package com.br.matchbook.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.matchbook.models.LiteraryGenre;

@Repository
public interface LiteraryGenreRepository extends CrudRepository<LiteraryGenre, Integer> {
}


