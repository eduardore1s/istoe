package com.puc.istoe.dtos;

import com.puc.istoe.entities.AlunoEntity;
import com.puc.istoe.entities.ProfessorEntity;

public class AlunoDto {

	private String nome;
	private String login;
	private String senha;
	private String email;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	private String curso;
	
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
		return new AlunoEntity(nome, senha, email, curso);
	}
}