package com.puc.istoe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puc.istoe.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
	
	UsuarioEntity findByLogin(String login);
	
}
