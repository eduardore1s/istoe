package com.puc.istoe.dtos;

import com.puc.istoe.entities.AlunoEntity;

public class AlunoDto {

	private String nome;
	private String login;
	private String senha;
	private String email;
	private String curso;
	
	public AlunoDto() {
		super();
	}
	
	public AlunoDto(String nome, String login, String senha, String email, String curso) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.curso = curso;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public AlunoEntity transformaParaEntity() {
		return new AlunoEntity(nome, senha, login, email, curso);
	}
}