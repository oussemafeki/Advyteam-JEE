package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Modules implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String nomModule;
	private String descriptionModule;
	private int flagActif;
	@ManyToOne
	@JsonBackReference(value="module")
	Project projet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="modules", fetch = FetchType.EAGER)
	 @JsonManagedReference(value="taches")
	private Set<Taches> taches;
	public Modules(int id, String nomModule, String descriptionModule) {
		super();
		this.id = id;
		this.nomModule = nomModule;
		this.descriptionModule = descriptionModule;
	}
	public Modules() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomModule() {
		return nomModule;
	}
	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}
	public String getDescriptionModule() {
		return descriptionModule;
	}
	public void setDescriptionModule(String descriptionModule) {
		this.descriptionModule = descriptionModule;
	}
	public Project getProjet() {
		return projet;
	}
	public void setProjet(Project projet) {
		this.projet = projet;
	}
	public Set<Taches> getTaches() {
		return taches;
	}
	public void setTaches(Set<Taches> taches) {
		this.taches = taches;
	}
	public int getFlagActif() {
		return flagActif;
	}
	public void setFlagActif(int flagActif) {
		this.flagActif = flagActif;
	}

	
}
