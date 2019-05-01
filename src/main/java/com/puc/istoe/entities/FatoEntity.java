package com.puc.istoe.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FATO")
public class FatoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFato;
	private Integer ordem;
	private String conteudo;
	private String topicoDisciplina;
	private String resposta;
	
	@OneToOne
	private JfEntity jf;

	@ManyToMany(targetEntity=AlunoEntity.class)
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

	public List<AlunoEntity> getAlunosReponderam() {
		return alunosReponderam;
	}

	public void setAlunosReponderam(List<AlunoEntity> alunosReponderam) {
		this.alunosReponderam = alunosReponderam;
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

	public JfEntity getJf() {
		return jf;
	}

	public void setJf(JfEntity jf) {
		this.jf = jf;
	}	
	
}
