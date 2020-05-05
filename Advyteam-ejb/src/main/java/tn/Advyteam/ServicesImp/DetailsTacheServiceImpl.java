package tn.Advyteam.ServicesImp;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.IDetailsTacheRemoteService;
import tn.Advyteam.entities.DetailsTache;

@Stateless
@LocalBean
public class DetailsTacheServiceImpl implements IDetailsTacheRemoteService {

	@PersistenceContext
	EntityManager em;

	@Override
	public int save(DetailsTache detailsTache) {
		em.persist(detailsTache);
		return detailsTache.getId();
	}

	@Override
	public List<DetailsTache> getDetailsTacheByDate(Date date) {
		TypedQuery<DetailsTache> query = em.createQuery("SELECT d FROM DetailsTache d WHERE d.date = :date",
				DetailsTache.class);
		query.setParameter("date", date);
		List<DetailsTache> details = query.getResultList();
		return details;
	}

	@Override
	public DetailsTache getDetailTacheByDateAndTache(Date date, tn.Advyteam.entities.Taches tache) {
		TypedQuery<DetailsTache> query = em.createQuery("SELECT d FROM DetailsTache d WHERE d.date = :date And d.tache.id = :idTache",
				DetailsTache.class);
		query.setParameter("date", date);
		query.setParameter("idTache", tache.getId());
		DetailsTache detail = query.getSingleResult();
		return detail;
	}

	@Override
	public void update(DetailsTache newDetailTache) {
		DetailsTache det = em.find(DetailsTache.class, newDetailTache.getId());
		det.setNbrHeures(newDetailTache.getNbrHeures());
		det.setDescription(newDetailTache.getDescription());
	}

}
