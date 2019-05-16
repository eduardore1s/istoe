package com.puc.istoe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.AlunoDto;
import com.puc.istoe.entities.AlunoEntity;
import com.puc.istoe.entities.UsuarioEntity;
import com.puc.istoe.services.AlunoService;
import com.puc.istoe.services.UsuarioService;

@RestController
@RequestMapping("api/alunos")
public class AlunoApiController {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private UsuarioService usuarioService;
	
	@CrossOrigin(origins = "http://localhost:8081")
	@PostMapping
	public ResponseEntity<AlunoDto> cadastrarAluno(@RequestBody AlunoDto alunoDto) {

		if (loginExistente(alunoDto.getLogin())) {
			return new ResponseEntity<AlunoDto>(HttpStatus.BAD_REQUEST);
		}

		final UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setLogin(alunoDto.getLogin());
		usuarioEntity.setSenha(alunoDto.getSenha());
		usuarioEntity.setTipo("ALUNO");

		final AlunoEntity alunoEntity = alunoDto.transformaParaEntity();
		alunoEntity.setUsuarioEntity(usuarioEntity);
		alunoService.salvar(alunoEntity);
		alunoDto.setIdAluno(alunoEntity.getIdAluno());
		return new ResponseEntity<AlunoDto>(alunoDto, HttpStatus.OK);
	}

	private Boolean loginExistente(String login) {
		return usuarioService.loginExists(login);
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@SuppressWarnings("unchecked")
	@GetMapping
	public ResponseEntity<List<AlunoDto>> buscarAlunos(@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "curso", required = false) String curso) {

		List<AlunoDto> response = new ArrayList<>();
		AlunoEntity alunoEntity;
		AlunoDto alunoDto; 

		if (login != null) {
			final UsuarioEntity usuarioEntity = usuarioService.buscarUsuario(login);
			alunoEntity = alunoService.buscarAlunoIdUsuario(usuarioEntity.getIdUsuario());
			if (usuarioEntity != null) {
				if (alunoEntity != null) {
					alunoDto = new AlunoDto();
					alunoDto.setCurso(alunoEntity.getCurso());
					alunoDto.setEmail(alunoEntity.getEmail());
					alunoDto.setIdAluno(alunoEntity.getIdAluno());
					alunoDto.setLogin(usuarioEntity.getLogin());
					alunoDto.setNome(alunoEntity.getNome());

					response.add(alunoDto);
					return new ResponseEntity<List<AlunoDto>>(response, HttpStatus.OK);
				}
			}
		}

		if (curso != null) {
			List<AlunoEntity> alunos = (List<AlunoEntity>) alunoService.buscarAlunos(curso);
			if (alunos != null) {
				for (AlunoEntity aluno : alunos) {
					alunoDto = new AlunoDto();
					alunoDto.setCurso(aluno.getCurso());
					alunoDto.setEmail(aluno.getEmail());
					alunoDto.setIdAluno(aluno.getIdAluno());
					if (aluno.getUsuarioEntity() != null) {
						alunoDto.setLogin(aluno.getUsuarioEntity().getLogin());
					}
					alunoDto.setNome(aluno.getNome());

					response.add(alunoDto);
				}
			}

			return new ResponseEntity<List<AlunoDto>>(response, HttpStatus.OK);
		}

		return new ResponseEntity<List<AlunoDto>>(HttpStatus.BAD_REQUEST);
	}

}
