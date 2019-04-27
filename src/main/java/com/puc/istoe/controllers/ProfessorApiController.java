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

		if (loginExistente(professorDto.getLogin())) {
			return new ResponseEntity<ProfessorDto>(HttpStatus.BAD_REQUEST);
		}

		final UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setLogin(professorDto.getLogin());
		usuarioEntity.setSenha(professorDto.getSenha());
		usuarioEntity.setTipo("PROFESSOR");

		final ProfessorEntity professorEntity = professorDto.transformaParaEntity();
		professorEntity.setUsuarioEntity(usuarioEntity);
		professorService.salvar(professorEntity);
		professorDto.setIdProfessor(professorEntity.getIdProfessor());
		return new ResponseEntity<ProfessorDto>(professorDto, HttpStatus.OK);
	}

	private Boolean loginExistente(String login) {
		return usuarioService.loginExists(login);
	}

	@GetMapping
	public ResponseEntity<ProfessorDto> buscarProfessor(@RequestParam String login) {

		final UsuarioEntity usuarioEntity = usuarioService.buscarUsuario(login);

		if (usuarioEntity != null) {
			final ProfessorEntity professorEntity = professorService.buscarProfessorIdUsuario(usuarioEntity.getIdUsuario());

			if (professorEntity != null) {
				final ProfessorDto professorDto = new ProfessorDto();
				professorDto.setEmail(professorEntity.getEmail());
				professorDto.setIdProfessor(professorEntity.getIdProfessor());
				professorDto.setLogin(usuarioEntity.getLogin());
				professorDto.setNome(professorEntity.getNome());
				return new ResponseEntity<ProfessorDto>(professorDto, HttpStatus.OK);
			}

		}

		return new ResponseEntity<ProfessorDto>(HttpStatus.BAD_REQUEST);
	}
}
