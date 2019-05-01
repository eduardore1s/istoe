package com.puc.istoe.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TURMA")
public class TurmaEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTURMA")
	private Long idTurma;
	private String disciplina;
	private String curso;
	private String unidade;
	
	@OneToOne
	private ProfessorEntity professorEntity;
	
	@ManyToMany(targetEntity=AlunoEntity.class)
	private Set alunos;

	public Set getAlunos() {
		return alunos;
	}

	public void setAlunos(Set alunos) {
		this.alunos = alunos;
	}

	public ProfessorEntity getProfessorEntity() {
		return professorEntity;
	}

	public void setProfessorEntity(ProfessorEntity professorEntity) {
		this.professorEntity = professorEntity;
	}

	public Long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
}
