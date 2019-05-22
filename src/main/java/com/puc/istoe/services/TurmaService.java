package com.puc.istoe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.istoe.entities.ProfessorEntity;
import com.puc.istoe.entities.TurmaEntity;
import com.puc.istoe.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

	public void salvar(TurmaEntity turmaEntity) {
		turmaRepository.save(turmaEntity);
	}
	
	public TurmaEntity buscarTurma(Long idTurma) {
		return turmaRepository.findByIdTurma(idTurma);
	}
	
	public List<TurmaEntity> buscarTurmasProfessor(ProfessorEntity professorEntity) {
		return turmaRepository.findByProfessorEntity(professorEntity);
	}
}
