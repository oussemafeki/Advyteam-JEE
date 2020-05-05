package tn.Advyteam.ServicesImp;



import java.util.List;
import java.util.concurrent.Semaphore;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.ICritereService;
import tn.Advyteam.entities.Critere;
import tn.Advyteam.entities.ManagerEval;
import tn.Advyteam.entities.Selfeval;

@Stateless 
@LocalBean 
public class CritereService implements ICritereService {
	@PersistenceContext
	EntityManager em;
	@Override
	public int ajouterCritere(Critere critere) {
		em.persist(critere);
		return critere.getId();
	}

	@Override
	public List<Critere> getAllCriteres() {
		List<Critere> cri = em.createQuery("SELECT c FROM Critere c ", Critere.class).getResultList(); 
		return cri;
	}

	@Override
	public void deleteCritereById(int critere) {
		em.remove(em.find(Critere.class, critere));
		
	}

	@Override
	public void updateCritere(Critere critere) {
		Critere cr = em.find(Critere.class, critere.getId());
		cr.setNom(critere.getNom());
		cr.setDescription(critere.getDescription());
		
	}

	@Override
	public List<Critere> getAllCriteresByUser(int IdUser) {
		TypedQuery<Selfeval> query =em.createQuery("Select s from Selfeval s WHERE s.employe=:employe", Selfeval.class); 
		query.setParameter("employe", IdUser);
		List<Selfeval> evals = null;
		
		try { evals = query.getResultList(); }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(evals+"_______evals________");
		
		if (evals.toString()=="[]")
		{
			System.out.println(em.createQuery("SELECT c FROM Critere c ", Critere.class).getResultList()+"_______cri when evals null________");
			return  em.createQuery("SELECT c FROM Critere c ", Critere.class).getResultList(); 
		}
		else
		{
		TypedQuery<Critere>query3 =em.createQuery("Select s.critere FROM Selfeval s WHERE s.employe=:IdUser",Critere.class);
		query3.setParameter("IdUser", IdUser);
		
	
		List<Critere>  cri3  = null;
		try { cri3 = query3.getResultList();  }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(cri3+"_______cri to not show________");
		
		TypedQuery<Critere>query2 =em.createQuery("Select c from Critere c WHERE c NOT IN :Criteres ",Critere.class);

		query2.setParameter("Criteres", cri3);
		List<Critere>  cri  = null;
		try { cri = query2.getResultList();  }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(cri+"_______cri to show________");
		return cri;
		}
	}

	@Override
	public String notification(int IdUser) {
		TypedQuery<Selfeval> query =em.createQuery("Select s from Selfeval s WHERE s.employe=:employe", Selfeval.class); 
		query.setParameter("employe", IdUser);
		List<Selfeval> evals = null;
		
		try { evals = query.getResultList(); }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(evals+"_______evals________");
		
		if (evals.toString()=="[]")
		{
			System.out.println(em.createQuery("SELECT c FROM Critere c ", Critere.class).getResultList()+"_______cri when evals null________");
			return "You have an evaluations to pass ! "+em.createQuery("SELECT c FROM Critere c ", Critere.class).getResultList(); 
		}
		else
		{
		TypedQuery<Critere>query3 =em.createQuery("Select s.critere FROM Selfeval s WHERE s.employe=:IdUser",Critere.class);
		query3.setParameter("IdUser", IdUser);
		
	
		List<Critere>  cri3  = null;
		try { cri3 = query3.getResultList();  }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(cri3+"_______cri to not show________");
		
		TypedQuery<Critere>query2 =em.createQuery("Select c from Critere c WHERE c NOT IN :Criteres ",Critere.class);

		query2.setParameter("Criteres", cri3);
		List<Critere>  cri  = null;
		try { cri = query2.getResultList();  }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(cri+"_______cri to show________");
		if((cri.toString()=="[]")||(cri.toString()==null))
		{
			return "Your evaluations is up to date ! ";
		}
		else
		{
			return "You have an evaluations to pass ! "+cri;
		}
		}
	}

	@Override
	public Critere getCritereById(int id) {
		Critere cr = em.find(Critere.class, id);
		return cr;
	}

	@Override
	public List<Critere> getAllCriteresByUserManager(int IdUser) {
		TypedQuery<ManagerEval> query =em.createQuery("Select s from ManagerEval s WHERE s.employe.id=:employe", ManagerEval.class); 
		query.setParameter("employe", IdUser);
		List<ManagerEval> evals = null;
		
		try { evals = query.getResultList(); }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(evals+"_______evals________");
		
		if (evals.toString()=="[]")
		{
			System.out.println(em.createQuery("SELECT c FROM Critere c ", Critere.class).getResultList()+"_______cri when evals null________");
			return  em.createQuery("SELECT c FROM Critere c ", Critere.class).getResultList(); 
		}
		else
		{
		TypedQuery<Critere>query3 =em.createQuery("Select s.critere FROM ManagerEval s WHERE s.employe.id=:IdUser",Critere.class);
		query3.setParameter("IdUser", IdUser);
		
	
		List<Critere>  cri3  = null;
		try { cri3 = query3.getResultList();  }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(cri3+"_______cri to not show________");
		
		TypedQuery<Critere>query2 =em.createQuery("Select c from Critere c WHERE c NOT IN :Criteres ",Critere.class);

		query2.setParameter("Criteres", cri3);
		List<Critere>  cri  = null;
		try { cri = query2.getResultList();  }
		catch (Exception e)
		{ System.out.println("Erreur : " + e); }
		System.out.println(cri+"_______cri to show________");
		return cri;
		}
	}

	

}
