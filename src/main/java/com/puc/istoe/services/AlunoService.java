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
	
	public Boolean loginExists(String login) {
		return alunoRepository.findByLogin(login) != null ? true : false;
	}
	
	public AlunoEntity buscarAluno(String login) {
		return alunoRepository.findByLogin(login);
	}
}
