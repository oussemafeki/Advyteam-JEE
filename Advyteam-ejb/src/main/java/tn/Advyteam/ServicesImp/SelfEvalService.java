package tn.Advyteam.ServicesImp;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.ISelfEvalService;
import tn.Advyteam.entities.Critere;
import tn.Advyteam.entities.Selfeval;



@Stateless 
@LocalBean 
public class SelfEvalService implements ISelfEvalService {
	@PersistenceContext
	EntityManager em;
	@Override
	public int ajouterSelfEval(Selfeval selfeval) {
		em.persist(selfeval);
		return selfeval.getId();
	}

	@Override
	public List<Selfeval> getAllSelfEvals(int employe) {


		TypedQuery<Selfeval> query =em.createQuery("Select s from Selfeval s WHERE s.employe=:employe", Selfeval.class); 
		query.setParameter("employe", employe);
		List<Selfeval> evals = null;
		try { evals = query.getResultList(); }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }

		return evals;
	}

	@Override
	public void deleteSelfEvalById(int SelfEvalId) {
		em.remove(em.find(Selfeval.class, SelfEvalId));

	}

	@Override
	public void updateSelfEval(Selfeval selfeval) {
		Selfeval se = em.find(Selfeval.class, selfeval.getId());
		se.setValue(selfeval.getValue());
		se.setDescription(selfeval.getDescription());

	}


	@Override
	public void affecterEvalCritere(int evalid, int critereid) {
		Selfeval seleval = em.find(Selfeval.class,evalid);
		Critere critere = em.find(Critere.class, critereid);
		critere.getEvals().add(seleval);
		em.merge(critere);
	}

	@Override
	public int ajouterCritere(Critere critere) {
		em.persist(critere);
		return critere.getId();
	}

	@Override
	public Critere getCritereByName(String name) {
	
		
		TypedQuery<Critere> query =em.createQuery("SELECT c FROM Critere c WHERE c.nom=:name", Critere.class); 
		query.setParameter("name", name);
		Critere cri  = null;
		try { cri = query.getSingleResult();  }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }

		return cri;
	}
	

	@Override
	public Double getMoy() {
		double moy  =0;
		try {
		 moy  =  em.createQuery("SELECT AVG(s.value) FROM Selfeval s ", Double.class).getSingleResult();
		 System.out.println(moy+"_____________________________________________"); 
		}
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		return moy;
	}

}
