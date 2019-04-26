package com.puc.istoe.controllers;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.TurmaDto;
import com.puc.istoe.entities.AlunoEntity;
import com.puc.istoe.entities.TurmaEntity;
import com.puc.istoe.services.AlunoService;
import com.puc.istoe.services.TurmaService;

@RestController
@RequestMapping("api/turmas")
public class TurmaApiController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<TurmaDto> cadastrarturma(@RequestBody TurmaDto turmaDto) {
		
		final TurmaEntity turmaEntity = turmaDto.transformaParaEntity();
		turmaEntity.setAlunos(new HashSet<>());
		AlunoEntity alunoEntity = new AlunoEntity("Sistemas", "Duduzao", "ed@gmail");
		alunoEntity.setIdUsuario(new Long(4));
		turmaEntity.getAlunos().add(alunoEntity);
		
		turmaService.salvar(turmaEntity);

		return new ResponseEntity<TurmaDto>(turmaDto, HttpStatus.OK);
	}

	@RequestMapping("/{idTurma}")
	@GetMapping
	public ResponseEntity<TurmaDto> buscarturma(@PathVariable("idTurma") Long idTurma) {

		final TurmaEntity turmaEntity = turmaService.buscarTurma(idTurma);

		if (turmaEntity != null) {
			final TurmaDto turmaDto = turmaEntity.transformaParaDto();
			turmaDto.setAlunos(new ArrayList<Long>());
				
			for (AlunoEntity aluno : alunoService.buscarAlunos()) {
				if (aluno.getCurso().equals(turmaDto.getCurso())){
					turmaDto.getAlunos().add(aluno.getIdAluno());
				}
			}
			
			return new ResponseEntity<TurmaDto>(turmaDto, HttpStatus.OK);
		}
		
		return new ResponseEntity<TurmaDto>(HttpStatus.BAD_REQUEST);
	}

//	@RequestMapping("/{idTurma}/alunos")
//	@PostMapping
//	public ResponseEntity<TurmaDto> incluirAluno(@PathVariable("idTurma") Long idTurma, @RequestBody Long idAluno) {
//
//		final TurmaEntity turmaEntity = turmaService.buscarTurma(idTurma);
//
//		if (turmaEntity != null) {
//			final TurmaDto turmaDto = turmaEntity.transformaParaDto();
//			turmaDto.setAlunos(new ArrayList<Long>());
//				
//			for (MatriculadoTurmaEntity matriculadoTurma : matriculadoTurmaService
//					.buscarAlunosMatriculadosNaTurma(turmaEntity.getIdTurma())) {
//				turmaDto.getAlunos().add(matriculadoTurma.getIdAluno());
//			}
//
//			return new ResponseEntity<TurmaDto>(turmaDto, HttpStatus.OK);
//		}
//		
//		return new ResponseEntity<TurmaDto>(HttpStatus.BAD_REQUEST);
//	}
	
}
