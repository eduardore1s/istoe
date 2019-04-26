package com.puc.istoe.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.puc.istoe.dtos.AlunoDto;

@Entity
@Table(name="ALUNO")
public class AlunoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idALUNO")
	private Long idAluno;
	private String curso;
	private String nome;
	private String email;
	@Column(name = "idUSUARIO")
	private Long idUsuario;
	
	@ManyToMany(targetEntity=TurmaEntity.class, cascade = CascadeType.ALL)
	private Set turmas;
	
	public AlunoEntity() {}
	
	public AlunoEntity(String curso, String nome, String email) {
		this.curso = curso;
		this.nome = nome;
		this.email = email;
	}

	public AlunoDto transformaParaDto() {
		return new AlunoDto(idAluno,null, null, curso, nome, email);
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Set getTurmas() {
		return turmas;
	}

	public void setTurmas(Set turmas) {
		this.turmas = turmas;
	}
	
	
	
}
