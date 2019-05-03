package com.puc.istoe.dtos;

import java.util.Set;

public class TurmaDto {

	private Long idTurma;
	private String disciplina;
	private String curso;
	private String unidade;
	private Long idProfessor;
	private Set alunos;
	
	public Set getAlunos() {
		return alunos;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public void setAlunos(Set alunos) {
		this.alunos = alunos;
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

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

}
