package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
@Entity
public class Project implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id;
private String title;
private String description;
private int flagActif;
private Date dateDebutProjet;

@OneToMany(cascade = CascadeType.ALL, mappedBy="projet", fetch = FetchType.EAGER)
@JsonManagedReference(value="module")
private Set<Modules> modules;




@OneToMany(cascade = CascadeType.ALL, mappedBy="projetaffectation", fetch = FetchType.EAGER)
@JsonManagedReference(value="projet")
private Set<AffectationProject> affectationProject;

@OneToMany(mappedBy = "projet",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//@JsonBackReference(value="missions")	
private List<Mission> missions;

public Project() {
	super();
}

public Project(String title, String description) {
	super();
	this.title = title;
	this.description = description;
}

public Project(int id, String title, String description) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public Set<AffectationProject> getAffectationProject() {
	return affectationProject;
}
public void setAffectationProject(Set<AffectationProject> affectationProject) {
	this.affectationProject = affectationProject;
}
public Set<Modules> getModules() {
	return modules;
}
public void setModules(Set<Modules> modules) {
	this.modules = modules;
}

public int getFlagActif() {
	return flagActif;
}

public void setFlagActif(int flagActif) {
	this.flagActif = flagActif;
}

@JsonProperty("dateDebutProjet")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
@JsonSerialize(using = DateSerializer.class)
@JsonDeserialize(using = DateDeserializer.class)
public Date getDateDebutProjet() {
	return dateDebutProjet;
}

public void setDateDebutProjet(Date dateDebutProjet) {
	this.dateDebutProjet = dateDebutProjet;
}
public List<Mission> getMissions() {
	return missions;
}

public void setMissions(List<Mission> missions) {
	this.missions = missions;
}

@Override
public String toString() {
	return title ;
}





}
