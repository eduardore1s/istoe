package com.puc.istoe.dtos;

import java.util.List;

public class TurmaDto {

	private Long idTurma;
	private String disciplina;
	private String curso;
	private String unidade;
	private Long idProfessor;
	private List alunos;
	
	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public void setAlunos(List alunos) {
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

	public List<Long> getAlunos() {
		return alunos;
	}

}
