package com.puc.istoe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puc.istoe.entities.AlunoEntity;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoEntity, Long>{
	
	AlunoEntity findByIdUsuario(Long idUsuario);
}
