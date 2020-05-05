package tn.Advyteam.managedBean;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.Advyteam.ServicesImp.CritereService;
import tn.Advyteam.entities.Critere;



@ManagedBean(name = "CritereBean") 
@SessionScoped 
public class CritereBean {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String description ;
	private Critere criteretoupdate = new Critere();
	
	
	@EJB
	CritereService cs;
	private List<Critere> criteres;
	private int idcritereuptodate;
	private String notification ;
	public String getNotification() {
		return cs.notification(1);
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public int getIdcritereuptodate() {
		return idcritereuptodate;
	}
	public void setIdcritereuptodate(int idcritereuptodate) {
		this.idcritereuptodate = idcritereuptodate;
	}
	public Critere getCriteretoupdate() {
		return criteretoupdate;
	}
	public void setCriteretoupdate(Critere criteretoupdate) {
		this.criteretoupdate = criteretoupdate;
	}
	public String updateCritereInit(Critere c){

		this.setNom(c.getNom());
		this.setDescription(c.getDescription());
		this.setIdcritereuptodate(c.getId());

		return "UpdateCriterion?faces-redirect=true";


	}
	public String updateCritere() { cs.updateCritere(new Critere(idcritereuptodate,nom,description));
	return "showCriterion?faces-redirect=true";
	}
	public List<Critere> getCriteres() { 
		criteres =cs.getAllCriteres();
		return criteres; }
	public List<Critere> getCriteresByUser() { 
		criteres =cs.getAllCriteresByUser(1);
		return criteres; }
	public String addCritere() { 
		Critere cr =new Critere(id, nom, description);
		cs.ajouterCritere(cr);
		return "showCriterion?faces-redirect=true";
	}
	public void removeCriterion(int criterion) { cs.deleteCritereById(criterion); }

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCriteres(List<Critere> criteres) {
		this.criteres = criteres;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
