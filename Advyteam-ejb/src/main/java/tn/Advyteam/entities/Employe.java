package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
public class Employe implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	
	private String nom;
	
	private String email;
	
	private String password;	
	
	private Boolean isActif;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="useraffectation")
	@JsonManagedReference(value="user")
	private Set<AffectationProject> affectationProject;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "employe")
	@JsonBackReference(value="mevals")
	private List<ManagerEval> Mevals;
	@ManyToMany
	@JsonBackReference
    private List<Conge> conges;
	


	public List<ManagerEval> getMevals() {
		return Mevals;
	}
	public void setMevals(List<ManagerEval> mevals) {
		Mevals = mevals;
	}

	@Enumerated(EnumType.STRING)
	private Role role;
	
public Employe() {};
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public List<Conge> getConges() {
		return conges;
	}
	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}
	public Employe( String prenom, String nom, String email, String password, Boolean isActif, Role role) {
		super();
		
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
	}
	public Employe(int id, String prenom, String nom, String email, String password, Boolean isActif, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
	}
	public Employe(int id, String prenom, String nom, String email, String password, Boolean isActif,
			List<Conge> conges, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		this.conges = conges;
		this.role = role;
	}
	public Set<AffectationProject> getAffectationProject() {
		return affectationProject;
	}
	public void setAffectationProject(Set<AffectationProject> affectationProject) {
		this.affectationProject = affectationProject;
	}
	
	
	
	
	
}