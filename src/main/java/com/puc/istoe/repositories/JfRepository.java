package com.puc.istoe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.puc.istoe.entities.JfEntity;

public interface JfRepository extends CrudRepository<JfEntity, Long>{

	JfEntity findByIdJf(Long idJf);
	
	List<JfEntity> findByTurmaEntityIdTurma(Long idTurma);
}
