package com.puc.istoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.istoe.entities.ProfessorEntity;
import com.puc.istoe.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public void salvar(ProfessorEntity professorEntity) {
		professorRepository.save(professorEntity);
	}

	public ProfessorEntity buscarProfessorIdUsuario(Long idUsuario) {
		return professorRepository.findByUsuarioEntityIdUsuario(idUsuario);
	}
	
	public ProfessorEntity buscarProfessorIdProfessor(Long idProfessor) {
		return professorRepository.findByIdProfessor(idProfessor);
	}
}
