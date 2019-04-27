package com.puc.istoe.dtos;

import java.util.List;

public class TurmaDto {
	
	private String disciplina;
	private String curso;
	private String unidade;
	private Long idProfessor;
	private List<Long> alunos;
	
	public TurmaDto(String disciplina, String curso, String unidade, Long idProfessor) {
		this.disciplina = disciplina;
		this.curso = curso;
		this.unidade = unidade;
		this.idProfessor = idProfessor;
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

	public void setAlunos(List<Long> alunos) {
		this.alunos = alunos;
	}

}
