package com.puc.istoe.dtos;

import com.puc.istoe.entities.ProfessorEntity;

public class ProfessorDto {
	
	private Long idProfessor;
	private String login;
	private String senha;
	private String nome;
	private String email;

	public ProfessorEntity transformaParaEntity() {
		final ProfessorEntity professorEntity = new ProfessorEntity();
		professorEntity.setNome(this.nome);
		professorEntity.setEmail(this.email);
		return professorEntity;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
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
