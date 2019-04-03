package com.puc.istoe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puc.istoe.dtos.ProfessorDto;

@Entity
@Table(name="professor")
public class ProfessorEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprofessor;
	
	private String nome;
	private String login;
	private String senha;
	private String email;
	
	public ProfessorEntity() {
		super();
	}
	
	public ProfessorEntity(String nome, String login, String senha, String email) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public Long getId() {
		return idprofessor;
	}

	public void setId(Long id) {
		this.idprofessor = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public ProfessorDto transformaParaDto() {
		return new ProfessorDto(nome, login, senha, email);
	}
	
	
}
