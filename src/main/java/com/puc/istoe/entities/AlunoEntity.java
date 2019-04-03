package com.puc.istoe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puc.istoe.dtos.AlunoDto;

@Entity
@Table(name="aluno")
public class AlunoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idaluno;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String curso;
	
	public AlunoEntity() {
		super();
	}
	
	public AlunoEntity(String nome, String senha, String login, String email, String curso) {
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.email = email;
		this.curso = curso;
	}
	
	public Long getId() {
		return idaluno;
	}

	public void setId(Long id) {
		this.idaluno = id;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}


	public AlunoDto transformaParaDto() {
		return new AlunoDto(nome, login, senha, email, curso);
	}
	
	
	
	
}
