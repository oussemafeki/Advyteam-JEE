package tn.Advyteam.ServicesImp;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.Advyteam.IServices.ICompetanceService;
import tn.Advyteam.entities.Competance;
import tn.Advyteam.entities.Poste;

@Stateless
@LocalBean
public class CompetanceService implements ICompetanceService {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public int addCompetance(Competance c) {
		System.out.println("Request to add a competance");
		em.persist(c);
		return c.getId();
		
	}

	@Override
	public void removeCompetance(int id) {
		System.out.println("In remove competance : ");
		em.remove(em.find(Competance.class, id));
		System.out.println("Out of competance : ");
	}

	@Override
	public void updateCompetance(Competance compet) {
		// TODO Auto-generated method stub
		Competance c = em.find(Competance.class, compet.getId ());
		c.setNom(compet.getNom());
		c.setDescription(compet.getDescription());
		c.setIsLiked(compet.getIsLiked());
		
	}

	@Override
	public Competance findCompetanceById(int id) {
		// TODO Auto-generated method stub
		System.out.println("In findCompetanceById : ");
		Competance compet = em.find(Competance.class, id);
		System.out.println("Out of findCompetanceById : "+compet.getNom());
		return compet;
	}

	@Override
	public List<Competance> getAllCompetance() {
		// TODO Auto-generated method stub
		List<Competance> compet = em.createQuery("Select c from Competance c", 
				Competance.class).getResultList();
		return compet;
	}

	@Override
	public void assignCompetanceToPoste(int idCompetance, int idPoste) {
		// TODO Auto-generated method stub
		Competance competanceManagedEntity = em.find(Competance.class, idCompetance);
		Poste posteManagedEntity = em.find(Poste.class, idPoste);

		if(posteManagedEntity.getCompetances() == null){
			List<Competance> competances = new ArrayList<>();
			competances.add(competanceManagedEntity);
			posteManagedEntity.setCompetances(competances);
		}else{
			posteManagedEntity.getCompetances().add(competanceManagedEntity);
		}
	}

}
