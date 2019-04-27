package com.puc.istoe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="JF")
public class JfEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJf;
	private String status;
	private String email;

	@OneToOne
	private TurmaEntity turmaEntity;
	
	@OneToOne
	private EquipeEntity equipeEntity;
	
	@OneToOne
	private ProfessorEntity professorEntity;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TurmaEntity getTurmaEntity() {
		return turmaEntity;
	}

	public void setTurmaEntity(TurmaEntity turmaEntity) {
		this.turmaEntity = turmaEntity;
	}

	public EquipeEntity getEquipeEntity() {
		return equipeEntity;
	}

	public void setEquipeEntity(EquipeEntity equipeEntity) {
		this.equipeEntity = equipeEntity;
	}

	public ProfessorEntity getProfessorEntity() {
		return professorEntity;
	}

	public void setProfessorEntity(ProfessorEntity professorEntity) {
		this.professorEntity = professorEntity;
	}
}
