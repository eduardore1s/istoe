package com.puc.istoe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puc.istoe.dtos.UsuarioDto;

@Entity
@Table(name="usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	
	private String login;
	private String senha;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UsuarioEntity() {
		super();
	}
	
	public UsuarioEntity(String login, String senha, String tipo) {
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public Long getId() {
		return idusuario;
	}
	public void setId(Long id) {
		this.idusuario = id;
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
	
	public UsuarioDto transformaParaDto() {
		return new UsuarioDto(login, senha, tipo);
	}
	
	
	
}
