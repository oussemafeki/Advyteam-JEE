package tn.Advyteam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity

public class ManagerEval implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column 
	private int value ;
	@Column 
	private String description ;
	@JsonBackReference(value="critere")
	@ManyToOne(optional = false, targetEntity=Critere.class)
	private Critere critere;
	@JsonBackReference(value="employe")
	@ManyToOne(optional = false, targetEntity=Employe.class)
	private Employe employe;
	
	public ManagerEval() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerEval(int id, int value, String description, Critere mcritere, Employe employe) {
		super();
		this.id = id;
		this.value = value;
		this.description = description;
		this.critere = mcritere;
		this.employe = employe;
	}
	@Override
	public String toString() {
		return "ManagerEval [id=" + id + ", value=" + value + ", description=" + description + ", critere=" + critere
				+ ", employe=" + employe + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((critere == null) ? 0 : critere.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employe == null) ? 0 : employe.hashCode());
		result = prime * result + id;
		result = prime * result + value;
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
		ManagerEval other = (ManagerEval) obj;
		if (critere == null) {
			if (other.critere != null)
				return false;
		} else if (!critere.equals(other.critere))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employe == null) {
			if (other.employe != null)
				return false;
		} else if (!employe.equals(other.employe))
			return false;
		if (id != other.id)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Critere getCritere() {
		return critere;
	}
	public void setCritere(Critere critere) {
		this.critere = critere;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
