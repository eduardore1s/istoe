package com.puc.istoe.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPE")
public class EquipeEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	
	@ManyToMany( targetEntity=AlunoEntity.class)
	private List<AlunoEntity> alunosParticipam;
	
	@ManyToMany( targetEntity=AlunoEntity.class)
	private List<AlunoEntity> alunosLideram;
	
	public List<AlunoEntity> getAlunosParticipam() {
		return alunosParticipam;
	}
	public void setAlunosParticipam(List<AlunoEntity> alunosParticipam) {
		this.alunosParticipam = alunosParticipam;
	}
	public List<AlunoEntity> getAlunosLideram() {
		return alunosLideram;
	}
	public void setAlunosLideram(List<AlunoEntity> alunosLideram) {
		this.alunosLideram = alunosLideram;
	}
	
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	
}
