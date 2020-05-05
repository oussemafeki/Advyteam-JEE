package tn.Advyteam.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Demande implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String etat;
	
	
	
	public Demande() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Demande [id=" + id + ", etat=" + etat + ", isValide=" + isValide + ", employe=" + employe + ", mission="
				+ mission + "]";
	}



	public Demande(String etat, Boolean isValide) {
		super();
		this.etat = etat;
		this.isValide = isValide;
	}



	private Boolean isValide = Boolean.TRUE;
	
	@ManyToOne
	//@JsonBackReference(value="employe")
	private Employe employe;
	
	@ManyToOne
	//@JsonBackReference(value="mission")
	private Mission mission;
	
	
	
	public Demande(Long id, String etat, Boolean isValide) {
		super();
		this.id = id;
		this.etat = etat;
		
		this.isValide = isValide;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Boolean getIsValide() {
		return isValide;
	}
	public void setIsValide(Boolean isValide) {
		this.isValide = isValide;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}


	
	
}
