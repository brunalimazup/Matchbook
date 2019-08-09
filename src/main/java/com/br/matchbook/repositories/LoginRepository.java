package com.br.matchbook.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.matchbook.models.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {
	Optional<Login> findByNicknameAndPassword(String nickname, String password);
	boolean existsByNickname(String nickName);
}
