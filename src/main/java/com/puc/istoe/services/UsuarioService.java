package com.puc.istoe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.istoe.entities.UsuarioEntity;
import com.puc.istoe.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvar(UsuarioEntity usuarioEntity) {
		usuarioRepository.save(usuarioEntity);
	}
	
	public Boolean loginExists(String login) {
		return usuarioRepository.findByLogin(login) != null ? true : false;
	}
	
	public UsuarioEntity buscarUsuario(String login) {
		return usuarioRepository.findByLogin(login);
	}
}
