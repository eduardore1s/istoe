package com.puc.istoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.ProfessorDto;
import com.puc.istoe.entities.ProfessorEntity;
import com.puc.istoe.services.ProfessorService;

@RestController
@RequestMapping("api/professores")
public class ProfessorApiController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	public ResponseEntity<ProfessorDto> cadastrarProfessor(@RequestBody ProfessorDto professorDto) {
		if (!loginExistente(professorDto.getLogin())) {
			ProfessorEntity professorEntity = professorDto.transformaParaEntity();
			professorService.salvar(professorEntity);
			return new ResponseEntity<ProfessorDto>(professorDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<ProfessorDto>(HttpStatus.BAD_REQUEST);
		}
	}
	
	private Boolean loginExistente(String login) {
		return professorService.loginExists(login);
	}
}
