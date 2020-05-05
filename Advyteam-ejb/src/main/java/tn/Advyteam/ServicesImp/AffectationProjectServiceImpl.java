package tn.Advyteam.ServicesImp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.Advyteam.IServices.IAffectationProjectRemote;
import tn.Advyteam.entities.AffectationProject;

@Stateless
@LocalBean
public class AffectationProjectServiceImpl implements IAffectationProjectRemote{

	@PersistenceContext
	EntityManager em;
	@Override
	public int save(AffectationProject affProject) {
		em.persist(affProject);
		return affProject.getId();
	}
	
	public void update(AffectationProject affProjet) {
		
	}

}
