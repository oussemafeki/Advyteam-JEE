package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Poste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String nom;
	private String description;
	private int salaire;
	@Enumerated(EnumType.STRING)
	private TypeContrat typeContrat;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Competance> competances;
	
	
	public List<Competance> getCompetances() {
		return competances;
	}
	public void setCompetances(List<Competance> competances) {
		this.competances = competances;
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
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	public TypeContrat getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Poste(int id, String nom, String description, int salaire, TypeContrat typeContrat) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.salaire = salaire;
		this.typeContrat = typeContrat;
	}
	
	public Poste(String nom, String description, int salaire, TypeContrat typeContrat) {
		super();
		this.nom = nom;
		this.description = description;
		this.salaire = salaire;
		this.typeContrat = typeContrat;
	}
	public Poste() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
