package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Competance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	private Boolean isLiked;
	@ManyToMany(mappedBy="competances",fetch=FetchType.EAGER)
	//@NotNull
	private Set<Poste> Postes;
	@ManyToMany(mappedBy="competance",fetch=FetchType.EAGER)
	//@NotNull
	private Set<Categorie> categorie;
	
	
	public Set<Categorie> getCategorie() {
		return categorie;
	}
	public void setCategorie(Set<Categorie> categorie) {
		this.categorie = categorie;
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
	public Boolean getIsLiked() {
		return isLiked;
	}
	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}
	public Set<Poste> getPostes() {
		return Postes;
	}
	public void setPostes(Set<Poste> postes) {
		Postes = postes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Competance(int id, String nom, String description, boolean isLiked) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.isLiked = isLiked;
	}
	
	public Competance(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	public Competance() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
