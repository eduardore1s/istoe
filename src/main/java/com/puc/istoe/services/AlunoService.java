package com.puc.istoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.istoe.entities.AlunoEntity;
import com.puc.istoe.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	public void salvar(AlunoEntity alunoEntity) {
		alunoRepository.save(alunoEntity);
	}
	
	public AlunoEntity buscarAluno(Long idUsuario) {
		return alunoRepository.findByIdUsuario(idUsuario);
	}
}

