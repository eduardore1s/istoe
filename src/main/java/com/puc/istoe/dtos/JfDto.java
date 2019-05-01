package com.puc.istoe.dtos;

public class JfDto {

	private Long idJf;
	private String status;
	private Integer tamMaxEquipes;
	private Integer tempoMaxExibicaoFato;
	
	public Long getIdJf() {
		return idJf;
	}
	public void setIdJf(Long idJf) {
		this.idJf = idJf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTamMaxEquipes() {
		return tamMaxEquipes;
	}
	public void setTamMaxEquipes(Integer tamMaxEquipes) {
		this.tamMaxEquipes = tamMaxEquipes;
	}
	public Integer getTempoMaxExibicaoFato() {
		return tempoMaxExibicaoFato;
	}
	public void setTempoMaxExibicaoFato(Integer tempoMaxExibicaoFato) {
		this.tempoMaxExibicaoFato = tempoMaxExibicaoFato;
	}
	
}
