package tn.Advyteam.ServicesImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.IModulesRemote;
import tn.Advyteam.entities.Modules;


@Stateless
@LocalBean
public class ModulesServiceRemoteImp implements IModulesRemote {
	@PersistenceContext
    EntityManager em;

	@Override
	public void addModule(Modules module) {
		module.setFlagActif(1);
		em.persist(module);
		
	}

	@Override
	public List<Modules> getAllModules() {
		TypedQuery<Modules> query = em.createQuery(
				  "SELECT e FROM Modules e WHERE e.flagActif ='"+1+"'", Modules.class);
				List<Modules> modules = query.getResultList();
	
		return modules;
	}

	@Override
	public void removeModule(int id) {
		Modules m=em.find(Modules.class,id);
		m.setFlagActif(0);
	
	}

	@Override
	public void updateModule(Modules newModule) {
	Modules m=em.find(Modules.class,newModule.getId());
	m.setNomModule(newModule.getNomModule());
	m.setDescriptionModule(newModule.getDescriptionModule());
		
	}

	@Override
	public Modules findModuleById(int id) {
		return em.find(Modules.class,id);
	}

	@Override
	public List<Modules> getModulesProjet(int id) {
		TypedQuery<Modules> query = em.createQuery(
				  "SELECT e FROM Modules e WHERE e.flagActif ='"+1+"'and e.projet.id ='"+id+"'", Modules.class);
				List<Modules> modules = query.getResultList();
	
		return modules;
	}
}
