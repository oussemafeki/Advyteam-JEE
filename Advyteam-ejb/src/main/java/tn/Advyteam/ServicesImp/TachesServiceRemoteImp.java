package tn.Advyteam.ServicesImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.ITachesRemote;

import tn.Advyteam.entities.Taches;

@Stateless
@LocalBean
public class TachesServiceRemoteImp implements ITachesRemote {
	@PersistenceContext
    EntityManager em;

	@Override
	public void addTache(Taches tache) {
		tache.setFlagActif(1);
		em.persist(tache);
		
	}

	@Override
	public List<Taches> getAllTaches() {
		TypedQuery<Taches> query = em.createQuery(
				  "SELECT e FROM Taches e WHERE e.flagActif ='"+1+"'", Taches.class);
				List<Taches> taches = query.getResultList();
	
		return taches;
	}

	@Override
	public void removeTache(int id) {
		Taches t=em.find(Taches.class,id);
		t.setFlagActif(0);
		
	}

	@Override
	public void updateTache(Taches newTache) {
		Taches t=em.find(Taches.class,newTache.getId());
		t.setDateEstimer(newTache.getDateEstimer());
		t.setDescriptionTache(newTache.getDescriptionTache());
		t.setEtat(newTache.getEtat());
		t.setNomTache(newTache.getNomTache());
		t.setDateDebut(newTache.getDateDebut());
		t.setDateFin(newTache.getDateFin());
		t.setEmploye(newTache.getEmploye());
	}

	@Override
	public Taches findTacheById(int id) {
		return em.find(Taches.class,id);
	}

	@Override
	public List<Taches> getTacheModule(int id) {
		TypedQuery<Taches> query = em.createQuery(
				  "SELECT e FROM Taches e WHERE e.flagActif ='"+1+"'and e.modules.id ='"+id+"'", Taches.class);
				List<Taches> taches = query.getResultList();
	
		return taches;
	}
}
