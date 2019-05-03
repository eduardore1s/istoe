package com.puc.istoe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.istoe.entities.JfEntity;
import com.puc.istoe.repositories.JfRepository;

@Service
public class JfService {

	@Autowired
	private JfRepository jfRepository;
	
	public void salvar(JfEntity jfEntity) {
		jfRepository.save(jfEntity);
	}
	
	public JfEntity buscarJf(Long idJf) {
		return jfRepository.findByIdJf(idJf);
	}
	
	public List<JfEntity> buscarJfPorTurma(Long idTurma){
		return jfRepository.findByTurmaEntityIdTurma(idTurma);
	}
}
