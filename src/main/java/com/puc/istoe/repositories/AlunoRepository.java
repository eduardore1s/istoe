package com.puc.istoe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puc.istoe.entities.AlunoEntity;

@Repository
public interface AlunoRepository extends CrudRepository<AlunoEntity, Long>{

	AlunoEntity findByUsuarioEntityIdUsuario(Long idUsuario);

	AlunoEntity findByIdAluno(Long idAluno);
	
	List<AlunoEntity> findByCurso(String curso);
}
