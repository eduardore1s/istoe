package com.puc.istoe.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ALUNO")
public class AlunoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;
	private String curso;
	private String nome;
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	private UsuarioEntity usuarioEntity;
	
	@ManyToMany(targetEntity=AlunoEntity.class)
	private List<TurmaEntity> turmas;
	
	@ManyToMany( targetEntity=AlunoEntity.class)
	private List<EquipeEntity> participaEquipes;
	
	@ManyToMany( targetEntity=AlunoEntity.class)
	private List<EquipeEntity> lideraEquipes;
	
	@ManyToMany( targetEntity=FatoEntity.class)
	private List<FatoEntity> fatosRespondios;

	public List<FatoEntity> getFatosRespondios() {
		return fatosRespondios;
	}

	public void setFatosRespondios(List<FatoEntity> fatosRespondios) {
		this.fatosRespondios = fatosRespondios;
	}

	public List<EquipeEntity> getParticipaEquipes() {
		return participaEquipes;
	}

	public void setParticipaEquipes(List<EquipeEntity> participaEquipes) {
		this.participaEquipes = participaEquipes;
	}

	public List<EquipeEntity> getLideraEquipes() {
		return lideraEquipes;
	}

	public void setLideraEquipes(List<EquipeEntity> lideraEquipes) {
		this.lideraEquipes = lideraEquipes;
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

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public List<TurmaEntity> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaEntity> turmas) {
		this.turmas = turmas;
	}
}
