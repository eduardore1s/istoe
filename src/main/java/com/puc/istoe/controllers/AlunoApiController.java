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
import com.puc.istoe.entities.UsuarioEntity;
import com.puc.istoe.services.AlunoService;
import com.puc.istoe.services.UsuarioService;

@RestController
@RequestMapping("api/alunos")
public class AlunoApiController {
//
//	@Autowired
//	private AlunoService alunoService;
//	
//	@Autowired
//	private UsuarioService usuarioService;
//	
//	@PostMapping
//	public ResponseEntity<AlunoDto> cadastrarAluno(@RequestBody AlunoDto alunoDto) {
//			
//		if (loginExistente(alunoDto.getLogin())) {
//			return new ResponseEntity<AlunoDto>(HttpStatus.BAD_REQUEST);
//		}
//		
//		UsuarioEntity usuarioEntity = new UsuarioEntity(alunoDto.getLogin(), alunoDto.getSenha(), "ALUNO");
//		usuarioService.salvar(usuarioEntity);
//		
//		usuarioEntity = usuarioService.buscarUsuario(alunoDto.getLogin());
//		
//		final AlunoEntity alunoEntity = alunoDto.transformaParaEntity();
//		alunoEntity.setIdUsuario(usuarioEntity.getIdUsuario());
//		alunoService.salvar(alunoEntity);
//			
//		return new ResponseEntity<AlunoDto>(alunoDto,HttpStatus.OK);		
//	}
//	
//	private Boolean loginExistente(String login) {
//		return usuarioService.loginExists(login);
//	}
//	
//	@GetMapping
//	public ResponseEntity<AlunoDto> buscarAluno(@RequestParam String login) {
//		
//		final UsuarioEntity usuarioEntity = usuarioService.buscarUsuario(login);
//		
//		if (usuarioEntity != null) {	
//			final AlunoEntity alunoEntity = alunoService.buscarAluno(usuarioEntity.getIdUsuario());
//			
//			if (alunoEntity != null) {
//				final AlunoDto alunoDto = alunoEntity.transformaParaDto();
//				alunoDto.setLogin(usuarioEntity.getLogin());
//				alunoDto.setSenha(usuarioEntity.getSenha());	
//				return new ResponseEntity<AlunoDto>(alunoDto, HttpStatus.OK);
//			}
//			
//		}
//		
//		return new ResponseEntity<AlunoDto>(HttpStatus.BAD_REQUEST);		
//	}

}
