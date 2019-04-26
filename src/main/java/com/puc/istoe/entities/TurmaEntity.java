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

import com.puc.istoe.dtos.TurmaDto;

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
	@Column(name = "idPROFESSOR")
	private Long idProfessor;
	
	@ManyToMany(targetEntity=AlunoEntity.class, cascade = CascadeType.ALL)
	private Set alunos;
	
	public TurmaEntity() {}
	
	public TurmaEntity(String disciplina, String curso, String unidade, Long idProfessor) {
		this.disciplina = disciplina;
		this.curso = curso;
		this.unidade = unidade;
		this.idProfessor = idProfessor;
	}
	
	public TurmaDto transformaParaDto() {
		return new TurmaDto(disciplina, curso, unidade, idProfessor);
	}
	
	
	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
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

	public Set getAlunos() {
		return alunos;
	}

	public void setAlunos(Set alunos) {
		this.alunos = alunos;
	}
	
}
