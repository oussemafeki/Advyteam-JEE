package tn.Advyteam.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.Advyteam.ServicesImp.PosteService;
import tn.Advyteam.entities.Poste;
import tn.Advyteam.entities.TypeContrat;

@ManagedBean(name="posteBean")
@SessionScoped
public class PosteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String description;
	private int salaire;
	private TypeContrat typeContrat;
	private List<Poste> postes;
	private Integer PosteIdToBeUpdate;
	
	@EJB
	PosteService posteService;

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

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	public PosteService getPosteService() {
		return posteService;
	}

	public void setPosteService(PosteService posteService) {
		this.posteService = posteService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Poste> getPostes() {
		postes= posteService.getAllPoste();
		return postes;
	}

	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}

	public Integer getPosteIdToBeUpdate() {
		return PosteIdToBeUpdate;
	}

	public void setPosteIdToBeUpdate(Integer posteIdToBeUpdate) {
		PosteIdToBeUpdate = posteIdToBeUpdate;
	}
	
	public void AddPoste() {
		posteService.addPoste(new Poste(nom, description, salaire, typeContrat));
	}
	public void RemovePoste(int posteId) {
		posteService.removePoste(posteId);
	}
	public void displayPoste(Poste pos) {
		this.setNom(pos.getNom());
		this.setDescription(pos.getDescription());
		this.setSalaire(pos.getSalaire());
		this.setTypeContrat(pos.getTypeContrat());
		this.setPosteIdToBeUpdate(pos.getId());
	}
	public void updatePoste() {
		posteService.updatePoste(new Poste(PosteIdToBeUpdate, nom, description, salaire, typeContrat));
	}

}
