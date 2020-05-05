package tn.Advyteam.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.Advyteam.ServicesImp.CompetanceService;
import tn.Advyteam.entities.Competance;

@ManagedBean(name="competanceBean")
@SessionScoped
public class CompetanceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String description;
	private Boolean isLiked;
	private List<Competance> competances;
	private Integer CompetanceIdToBeUpdate;
	
	@EJB
	CompetanceService competanceService;
	
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
	public Boolean getIsLiked() {
		return isLiked;
	}
	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}
	public CompetanceService getCompetanceService() {
		return competanceService;
	}
	public void setCompetanceService(CompetanceService competanceService) {
		this.competanceService = competanceService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Competance> getCompetances() {
		competances=competanceService.getAllCompetance();
		return competances;
	}
	public void setCompetances(List<Competance> competances) {
		this.competances = competances;
	}
	public Integer getCompetanceIdToBeUpdate() {
		return CompetanceIdToBeUpdate;
	}
	public void setCompetanceIdToBeUpdate(Integer competanceIdToBeUpdate) {
		CompetanceIdToBeUpdate = competanceIdToBeUpdate;
	}
	public String AddCompetance() {
		competanceService.addCompetance(new Competance(nom, description));
		return "showCompet?faces-redirect=true";
	}
	public void removeCompetance(int competanceId){
		competanceService.removeCompetance(competanceId);
	}
	public void displayCompetance(Competance comp) {
		this.setNom(comp.getNom());
		this.setDescription(comp.getDescription());
		this.setIsLiked(comp.getIsLiked());
		this.setCompetanceIdToBeUpdate(comp.getId());
	}	
	public void updateCompetance() {
		competanceService.updateCompetance(new Competance(CompetanceIdToBeUpdate, nom, description, isLiked));
	}
	
}
