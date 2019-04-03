package com.puc.istoe.dtos;

import com.puc.istoe.entities.UsuarioEntity;

public class UsuarioDto {

	private String login;
	private String senha;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UsuarioDto() {
		super();
	}
	
	public UsuarioDto(String login, String senha, String tipo) {
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public UsuarioEntity transformaParaEntity() {
		return new UsuarioEntity(login, senha, tipo);
	}
	
	
}
