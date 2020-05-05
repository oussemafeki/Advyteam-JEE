package tn.Advyteam.ServicesImp;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.IManagerEvalService;
import tn.Advyteam.entities.Critere;
import tn.Advyteam.entities.ManagerEval;
import tn.Advyteam.entities.Selfeval;
@Stateless 
@LocalBean 
public class ManagerEvalService implements IManagerEvalService {
	@PersistenceContext
	EntityManager em;
	@Override
	public List<ManagerEval> getAllmanagerevals(int IdUser) {

		TypedQuery<ManagerEval> query =em.createQuery("Select s from ManagerEval s WHERE s.employe.id=:IdUser", ManagerEval.class); 
		query.setParameter("IdUser", IdUser);
		List<ManagerEval> evals = null;
		try { evals = query.getResultList(); }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }

		return evals;
	}
	

}
