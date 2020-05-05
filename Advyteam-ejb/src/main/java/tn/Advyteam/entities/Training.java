package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
public class Training implements Serializable {


	private static final long serialVersionUID = -5369734855993305723L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int nbplace;
	private String name;
	@JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
	private Date date;
	private String Description;
	//@Enumerated(EnumType.STRING)
	//private Domaine domaine;
	
	
	@ManyToMany
	@JsonBackReference
	private List<Employe> employee;

	
	/*@ManyToOne
	private Organization organisation;*/

	
	public Training() {
		super();
	}

	public Training(int id, int nbplace, String name, Date date, String description, List<Employe> employee) {
		super();
		this.id = id;
		this.nbplace = nbplace;
		this.name = name;
		this.date = date;
		Description = description;
		this.employee = employee;
	}
	public Training(int id , String name, Date date, String description,int nbplace) {
		super();
		this.id = id;
		
		this.name = name;
		this.date = date;
		Description = description;
		this.nbplace = nbplace;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	

	public int getNbplace() {
		return nbplace;
	}

	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}

	public List<Employe> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employe> employee) {
		this.employee = employee;
	}

	/*public Organization getOrganisation() {
		return organisation;
	}
*/
	/*public void setOrganisation(Organization organisation) {
		this.organisation = organisation;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*public Training(int id, String name, Date date, String description, Domaine domaine, List<User> employee,
			Organization organisation) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.Description = description;
		this.domaine = domaine;
		this.employee = employee;
		this.organisation = organisation;
	}*/
	
/*
	public Training(int id, String name, Date date, String description, Domaine domaine, List<Employee> employee) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		Description = description;
		this.domaine = domaine;
		this.employee = employee;
	}

	public Training() {
		super();
	}
*/
	

/*	public Training(String name, Date date, String description, Domaine domaine, Organization organisation) {
		super();
		this.name = name;
		this.date = date;
		this.Description = description;
		this.domaine = domaine;
		this.organisation= organisation;
	}*/
	

	/*public Training(int id, String name, String description, Domaine domaine, Organization organisation) {
		super();
		this.id = id;
		this.name = name;
		
		Description = description;
		this.domaine = domaine;
		this.organisation = organisation;
	}*/

/*	public Domaine getDomaine() {
		return domaine;
	}*/

/*	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}*/

	public Training(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		Description = description;
	}

	/*public Training(int id, String name, Date date, String description, Domaine domaine, 
			Organization organisation) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.Description = description;
		this.domaine = domaine;
	
		this.organisation = organisation;
	}*/

/*	public Training(int id, String name, String description, Domaine domaine) {
		super();
		this.id = id;
		this.name = name;
		Description = description;
		//this.domaine = domaine;
	}

	public int getNbplace() {
		return nbplace;
	}

	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}
*/
	public Training( String name, Date date, String description,  int nbplace) {
		super();
		
	
		this.name = name;
		this.date = date;
		Description = description;
		
		this.nbplace = nbplace;
	}
	
	
	
	
	
}
