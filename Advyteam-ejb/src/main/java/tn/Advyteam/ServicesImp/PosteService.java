package tn.Advyteam.ServicesImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.Advyteam.IServices.IPosteService;
import tn.Advyteam.entities.Poste;

@Stateless
@LocalBean
public class PosteService implements IPosteService {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public int addPoste(Poste p) {
		// TODO Auto-generated method stub
		System.out.println("Request to add a poste");
		em.persist(p);
		return p.getId();
		
	}

	@Override
	public void removePoste(int id) {
		// TODO Auto-generated method stub
		System.out.println("In remove poste : ");
		em.remove(em.find(Poste.class, id));
		System.out.println("Out of poste : ");
	}

	@Override
	public void updatePoste(Poste pos) {
		// TODO Auto-generated method stub
		Poste c = em.find(Poste.class, pos.getId());
		c.setNom(pos.getNom());
		c.setDescription(pos.getDescription());
		c.setSalaire(pos.getSalaire());
		c.setTypeContrat(pos.getTypeContrat());
		
	}

	@Override
	public Poste findPosteById(int id) {
		// TODO Auto-generated method stub
		System.out.println("In findPosteById : ");
		Poste pos = em.find(Poste.class, id);
		System.out.println("Out of findPosteById : "+pos.getNom());
		return pos;
	}

	@Override
	public List<Poste> getAllPoste() {
		// TODO Auto-generated method stub
		List<Poste> pos = em.createQuery("Select p from Poste p", 
				Poste.class).getResultList();
		return pos;
	}

}
