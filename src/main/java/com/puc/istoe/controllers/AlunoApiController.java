package com.puc.istoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.AlunoDto;
import com.puc.istoe.entities.AlunoEntity;
import com.puc.istoe.services.AlunoService;

@RestController
@RequestMapping("api/alunos")
public class AlunoApiController {

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping
	public ResponseEntity<AlunoDto> cadastrarAluno(@RequestBody AlunoDto alunoDto) {
		if (!loginExistente(alunoDto.getLogin())) {
			AlunoEntity alunoEntity = alunoDto.transformaParaEntity();
			alunoService.salvar(alunoEntity);
			return new ResponseEntity<AlunoDto>(alunoDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<AlunoDto>(HttpStatus.BAD_REQUEST);
		}
	}
	
	private Boolean loginExistente(String login) {
		return alunoService.loginExists(login);
	}
	
	@GetMapping
	public ResponseEntity<AlunoDto> buscarAluno(@RequestParam String login) {
		return new ResponseEntity<AlunoDto>(alunoService.buscarAluno(login).transformaParaDto(), HttpStatus.OK);
	}

}
