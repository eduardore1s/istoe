package com.puc.istoe.dtos;

import com.puc.istoe.entities.AlunoEntity;

public class AlunoDto {

	private Long idAluno;
	private String login;
	private String senha;
	private String curso;
	private String nome;
	private String email;
	
	public AlunoEntity transformaParaEntity() {
		final AlunoEntity alunoEntity = new AlunoEntity();
		alunoEntity.setCurso(this.curso);
		alunoEntity.setNome(this.nome);
		alunoEntity.setEmail(this.email);
		return alunoEntity;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}