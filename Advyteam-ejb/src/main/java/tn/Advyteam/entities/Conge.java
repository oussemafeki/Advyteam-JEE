package tn.Advyteam.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Conge implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id ; 
	 private Date DateDebut;
	 private Date DateFin;
	 private String typeConge;
	 private String certefica;
	 private String reponse ;
	 private String demandeConge ;
	 private int nbr_jr ;
	 private String status;
	 

	 @ManyToMany(mappedBy="conges")
	 @JsonBackReference
     private List<Employe> iduser;

	public Conge() {
		super();
	}

	public int getId() {
		return id;
	}

	public int getNbr_jr() {
		return nbr_jr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNbr_jr(int nbr_jr) {
		this.nbr_jr = nbr_jr;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	public List<Employe> getIduser() {
		return iduser;
	}

	public void setIduser(List<Employe> iduser) {
		this.iduser = iduser;
	}


	public String getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(String typeConge) {
		this.typeConge = typeConge;
	}

	public String getCertefica() {
		return certefica;
	}

	public void setCertefica(String certefica) {
		this.certefica = certefica;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getDemandeConge() {
		return demandeConge;
	}

	public void setDemandeConge(String demandeConge) {
		this.demandeConge = demandeConge;
	}


	public Conge(int id, Date dateDebut, Date dateFin, String typeConge, String certefica, String reponse,
			String demandeConge, List<Employe> iduser) {
		super();
		this.id = id;
		DateDebut = dateDebut;
		DateFin = dateFin;
		this.typeConge = typeConge;
		this.certefica = certefica;
		this.reponse = reponse;
		this.demandeConge = demandeConge;
		this.iduser = iduser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateDebut == null) ? 0 : DateDebut.hashCode());
		result = prime * result + ((DateFin == null) ? 0 : DateFin.hashCode());
		result = prime * result + ((certefica == null) ? 0 : certefica.hashCode());
		result = prime * result + ((demandeConge == null) ? 0 : demandeConge.hashCode());
		result = prime * result + id;
		result = prime * result + ((iduser == null) ? 0 : iduser.hashCode());
		result = prime * result + ((reponse == null) ? 0 : reponse.hashCode());
		result = prime * result + ((typeConge == null) ? 0 : typeConge.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conge other = (Conge) obj;
		if (DateDebut == null) {
			if (other.DateDebut != null)
				return false;
		} else if (!DateDebut.equals(other.DateDebut))
			return false;
		if (DateFin == null) {
			if (other.DateFin != null)
				return false;
		} else if (!DateFin.equals(other.DateFin))
			return false;
		if (certefica == null) {
			if (other.certefica != null)
				return false;
		} else if (!certefica.equals(other.certefica))
			return false;
		if (demandeConge == null) {
			if (other.demandeConge != null)
				return false;
		} else if (!demandeConge.equals(other.demandeConge))
			return false;
		if (id != other.id)
			return false;
		if (iduser == null) {
			if (other.iduser != null)
				return false;
		} else if (!iduser.equals(other.iduser))
			return false;
		if (reponse == null) {
			if (other.reponse != null)
				return false;
		} else if (!reponse.equals(other.reponse))
			return false;
		if (typeConge == null) {
			if (other.typeConge != null)
				return false;
		} else if (!typeConge.equals(other.typeConge))
			return false;
		return true;
	}



}
