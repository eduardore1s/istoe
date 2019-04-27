package com.puc.istoe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puc.istoe.dtos.UsuarioDto;

@Entity
@Table(name="USUARIO")
public class UsuarioEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String login;	
	private String senha;	
	private String tipo;
	
	public UsuarioEntity() {}
	
	public UsuarioEntity(String login, String senha, String tipo) {
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public UsuarioDto transformaParaDto() {
		return new UsuarioDto(login, senha, tipo);
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
