package tn.Advyteam.entities;

import java.util.Date;

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
public class AffectationProject {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	 
private Date dateAffectation;
	
private Date dateFin;
@ManyToOne
@JsonBackReference(value="projet")
Project projetaffectation;
@ManyToOne
@JsonBackReference(value="user")
Employe useraffectation;
public AffectationProject() {
	super();
}
public AffectationProject(int id, Date dateAffectation, Date dateFin) {
	super();
	this.id = id;
	this.dateAffectation = dateAffectation;
	this.dateFin = dateFin;
}
public AffectationProject(int id, Date dateAffectation, Date dateFin, Project projetaffectation, Employe useraffectation) {
	super();
	this.id = id;
	this.dateAffectation = dateAffectation;
	this.dateFin = dateFin;
	this.projetaffectation = projetaffectation;
	this.useraffectation = useraffectation;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@JsonProperty("creationDateTimeaff")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
@JsonSerialize(using = DateSerializer.class)
@JsonDeserialize(using = DateDeserializer.class)
public Date getDateAffectation() {
	return dateAffectation;
}
public void setDateAffectation(Date dateAffectation) {
	this.dateAffectation = dateAffectation;
}
@JsonProperty("creationDateTimefin")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
@JsonSerialize(using = DateSerializer.class)
@JsonDeserialize(using = DateDeserializer.class)
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
public Project getProjetaffectation() {
	return projetaffectation;
}
public void setProjetaffectation(Project projetaffectation) {
	this.projetaffectation = projetaffectation;
}
public Employe getUseraffectation() {
	return useraffectation;
}
public void setUseraffectation(Employe useraffectation) {
	this.useraffectation = useraffectation;
}





}
