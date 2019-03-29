package com.puc.istoe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class AlunoEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String curso;
	
	public AlunoEntity(String nome, String senha, String email, String curso) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.curso = curso;
	}
	
}
