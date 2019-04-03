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

import com.puc.istoe.dtos.ProfessorDto;
import com.puc.istoe.entities.ProfessorEntity;
import com.puc.istoe.entities.UsuarioEntity;
import com.puc.istoe.services.ProfessorService;
import com.puc.istoe.services.UsuarioService;

@RestController
@RequestMapping("api/professores")
public class ProfessorApiController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<ProfessorDto> cadastrarProfessor(@RequestBody ProfessorDto professorDto) {
		if (!loginExistente(professorDto.getLogin())) {
			ProfessorEntity professorEntity = professorDto.transformaParaEntity();
			professorService.salvar(professorEntity);
			UsuarioEntity usuarioEntity = new UsuarioEntity();
			usuarioEntity.setLogin(professorDto.getLogin());
			usuarioEntity.setSenha(professorDto.getSenha());
			usuarioEntity.setTipo("PROFESSOR");
			usuarioService.salvar(usuarioEntity);
			return new ResponseEntity<ProfessorDto>(professorDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<ProfessorDto>(HttpStatus.BAD_REQUEST);
		}
	}
	
	private Boolean loginExistente(String login) {
		return usuarioService.loginExists(login);
	}
	
	@GetMapping
	public ResponseEntity<ProfessorDto> buscarProfessor(@RequestParam String login) {
		ProfessorDto professor = professorService.buscarProfessor(login).transformaParaDto();
		if (professor != null) {
			return new ResponseEntity<ProfessorDto>(professor, HttpStatus.OK);
		}else {
			return new ResponseEntity<ProfessorDto>(HttpStatus.BAD_REQUEST);
		}		
	}
}
