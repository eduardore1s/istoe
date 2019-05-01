package com.puc.istoe.services;

import java.util.List;

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

	public AlunoEntity buscarAlunoIdUsuario(Long idUsuario) {
		return alunoRepository.findByUsuarioEntityIdUsuario(idUsuario);
	}

	public AlunoEntity buscarAlunoIdAluno(Long idAluno) {
		return alunoRepository.findByIdAluno(idAluno);
	}

	public List<AlunoEntity> buscarAlunos(String curso) {
		return alunoRepository.findByCurso(curso);
	}
}

