package com.puc.istoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.istoe.dtos.UsuarioDto;
import com.puc.istoe.entities.UsuarioEntity;
import com.puc.istoe.services.UsuarioService;

@RestController
@RequestMapping("api/login")
public class LoginApiController {

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping
	public ResponseEntity<UsuarioDto> realizarLogin(@RequestParam String login, @RequestParam String senha) {
		final UsuarioEntity usuarioEntity = usuarioService.buscarUsuario(login);

		if (usuarioEntity != null) {
			final UsuarioDto usuario = usuarioEntity.transformaParaDto();

			if (senha.equals(usuario.getSenha())) {
				return new ResponseEntity<UsuarioDto>(usuario, HttpStatus.OK);
			}
		}

		return new ResponseEntity<UsuarioDto>(HttpStatus.BAD_REQUEST);
	}
}
