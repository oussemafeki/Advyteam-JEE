package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
public class Taches implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String nomTache;
	private String descriptionTache;
	 
	private int dateEstimer;
	
	private Date dateDebut;

	private Date dateFin;
	private int flagActif;
	@ManyToOne
	@JsonBackReference
	Employe employe;
	

	
	private int etat;
	@ManyToOne
	@JsonBackReference(value="taches")
	Modules modules;
	

	public Taches(int id, String nomTache, String descriptionTache, int dateEstimer, Date dateDebut, Date dateFin,
			int etat) {
		super();
		this.id = id;
		this.nomTache = nomTache;
		this.descriptionTache = descriptionTache;
		this.dateEstimer = dateEstimer;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
	}

	public Taches() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomTache() {
		return nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	public String getDescriptionTache() {
		return descriptionTache;
	}

	public void setDescriptionTache(String descriptionTache) {
		this.descriptionTache = descriptionTache;
	}
	
	public int getDateEstimer() {
		return dateEstimer;
	}

	public void setDateEstimer(int dateEstimer) {
		this.dateEstimer = dateEstimer;
	}
	@JsonProperty("creationDateTimedebut")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	@JsonProperty("creationDateTimef")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Modules getModules() {
		return modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}

	public int getFlagActif() {
		return flagActif;
	}

	public void setFlagActif(int flagActif) {
		this.flagActif = flagActif;
	}

	

}
