package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Critere implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column 
	private String nom ;
	@Column 
	private String description ;
	
	
	@OneToMany(mappedBy = "critere",cascade=CascadeType.ALL)
	@JsonBackReference(value="sevals")
	private List<Selfeval> evals;
	
	
	@OneToMany(mappedBy = "critere",cascade=CascadeType.ALL )
	@JsonBackReference(value="mevals")
	private List<ManagerEval> Mevals;
	
	
	public List<Selfeval> getEvals() {
		return evals;
	}
	public void setEvals(List<Selfeval> evals) {
		this.evals = evals;
	}
	public Critere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Critere(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return nom ;
	}
	
}
