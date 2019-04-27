package com.puc.istoe.dtos;

public class AlunoDto {

	private Long idAluno;
	private String login;
	private String senha;
	private String curso;
	private String nome;
	private String email;
	
	public AlunoDto(Long idAluno, String login, String senha, String curso, String nome, String email) {
		this.idAluno = idAluno;
		this.login = login;
		this.senha = senha;
		this.curso = curso;
		this.nome = nome;
		this.email = email;
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