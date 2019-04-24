package com.puc.istoe.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puc.istoe.dtos.ProfessorDto;

@Entity
@Table(name="PROFESSOR")
public class ProfessorEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPROFESSOR")
	private Long idProfessor;
	private String nome;
	private String email;
	@Column(name = "idUSUARIO")
	private Long idUsuario;
	
	public ProfessorEntity() {}
	
	public ProfessorEntity(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public ProfessorDto transformaParaDto() {
		return new ProfessorDto(null, null, nome, email);
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
