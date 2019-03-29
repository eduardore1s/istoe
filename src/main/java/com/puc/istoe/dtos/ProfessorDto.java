package com.puc.istoe.dtos;

import com.puc.istoe.entities.ProfessorEntity;

public class ProfessorDto {
	
	private String nome;
	private String login;
	private String senha;
	private String email;
	
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
	
	public ProfessorEntity transformaParaEntity() {
		return new ProfessorEntity(nome, senha, email);
	}
	
}
