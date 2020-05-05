package tn.Advyteam.ServicesImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.IUserRemote;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Taches;


@Stateless
@LocalBean
public class UserServiceRemoteImpl implements IUserRemote{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Employe> getAllUsers() {
		return em.createQuery("from User", Employe.class).getResultList();
	}

	// à changer
	@Override
	public Employe getConnectedUser() {
		return em.find(Employe.class, 1);
	}

}
