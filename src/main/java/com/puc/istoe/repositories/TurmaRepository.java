package com.puc.istoe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.puc.istoe.entities.TurmaEntity;

@Repository
public interface TurmaRepository  extends CrudRepository<TurmaEntity, Long>{

	TurmaEntity findByIdTurma(Long idTurma);
}
