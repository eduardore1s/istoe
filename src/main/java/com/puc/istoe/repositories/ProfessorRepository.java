package com.puc.istoe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puc.istoe.entities.ProfessorEntity;

@Repository
public interface ProfessorRepository extends CrudRepository<ProfessorEntity, Long>{

	ProfessorEntity findByUsuarioEntityIdUsuario(Long idUsuario);
}
