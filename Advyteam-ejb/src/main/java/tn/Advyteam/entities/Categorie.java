package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categorie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Competance> competance;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
