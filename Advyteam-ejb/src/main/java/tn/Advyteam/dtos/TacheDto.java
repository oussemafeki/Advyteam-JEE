package tn.Advyteam.dtos;

import java.util.Date;

public class TacheDto {
	
	private int idTache;
	
	private String nomModule;
	
	private String nomTache;
	
	private String descriptionTache;
	
	private int dateEstimer;
	
	private int etat;
	
	private String nomEmploye;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private int nbrHeures;
	
	public TacheDto() {
		// TODO Auto-generated constructor stub
	}
	
	public TacheDto(int idTache, String nomModule, String nomTache, String descriptionTache, int dateEstimer, int etat, String nomEmploye) {
		super();
		this.idTache = idTache;
		this.nomModule = nomModule;
		this.nomTache = nomTache;
		this.descriptionTache = descriptionTache;
		this.dateEstimer = dateEstimer;
		this.etat = etat;
		this.nomEmploye = nomEmploye;
	}

	public TacheDto(String nomModule, String nomTache, String descriptionTache, int dateEstimer) {
		super();
		this.nomModule = nomModule;
		this.nomTache = nomTache;
		this.descriptionTache = descriptionTache;
		this.dateEstimer = dateEstimer;
	}
	
	public TacheDto(int idTache, String nomModule, String nomTache, String descriptionTache, int dateEstimer, int etat,
			String nomEmploye, Date dateDebut, Date dateFin) {
		super();
		this.idTache = idTache;
		this.nomModule = nomModule;
		this.nomTache = nomTache;
		this.descriptionTache = descriptionTache;
		this.dateEstimer = dateEstimer;
		this.etat = etat;
		this.nomEmploye = nomEmploye;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
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

	public int getIdTache() {
		return idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNbrHeures() {
		return nbrHeures;
	}

	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}
	
	
}
