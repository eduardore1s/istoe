package com.puc.istoe.dtos;

import java.util.List;

import com.puc.istoe.entities.AlunoEntity;

public class FatoDto {
	
	private Long idFato;
	private Integer ordem;
	private String conteudo;
	private String topicoDisciplina;
	private String resposta;
	private Long idJf;
	private List<AlunoEntity> alunosReponderam;
	public Long getIdFato() {
		return idFato;
	}
	public void setIdFato(Long idFato) {
		this.idFato = idFato;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getTopicoDisciplina() {
		return topicoDisciplina;
	}
	public void setTopicoDisciplina(String topicoDisciplina) {
		this.topicoDisciplina = topicoDisciplina;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public Long getIdJf() {
		return idJf;
	}
	public void setIdJf(Long idJf) {
		this.idJf = idJf;
	}
	public List<AlunoEntity> getAlunosReponderam() {
		return alunosReponderam;
	}
	public void setAlunosReponderam(List<AlunoEntity> alunosReponderam) {
		this.alunosReponderam = alunosReponderam;
	}
	
	
}
