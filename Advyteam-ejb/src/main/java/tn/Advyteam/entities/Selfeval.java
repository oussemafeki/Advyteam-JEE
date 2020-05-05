package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity

public class Selfeval implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column 
	private int value ;
	@Column 
	private String description ;
	@Column 
	private int employe ;
	

	

	@ManyToOne(optional = false, targetEntity=Critere.class)
	private Critere critere;
	
	public Selfeval() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Selfeval(int id, int value, String description) {
		super();
		this.id = id;
		this.value = value;
		this.description = description;
	}


	public Selfeval(int id, int value, String description, int employe, Critere critere) {
		super();
		this.id = id;
		this.value = value;
		this.description = description;
		this.employe = employe;
		this.critere = critere;
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
	public int getEmploye() {
		return employe;
	}
	public void setEmploye(int employe) {
		this.employe = employe;
	}
	
	public Critere getCritere() {
		return critere;
	}
	public void setCritere(Critere critere) {
		this.critere = critere;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Selfeval [id=" + id + ", value=" + value + ", description=" + description + ", employe=" + employe
				+ ", critere=" + critere + "]";
	}
}
