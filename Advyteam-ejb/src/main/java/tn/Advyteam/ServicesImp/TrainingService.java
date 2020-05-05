package tn.Advyteam.ServicesImp;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.Advyteam.IServices.ITrainingService;
import tn.Advyteam.entities.Training;








@Stateless
@LocalBean
public class TrainingService implements ITrainingService {
	@PersistenceContext
	EntityManager em;

	@Override
	public Training findById(int idTest) {
		Training test=em.find(Training.class, idTest);
		return test;
	}
	
	@Override
	public int addTraining(Training training) {
		em.persist(training);
		return training.getId();
	}
	@Override
	public List<Training> getAllTrainings() {
		List<Training> emp = em.createQuery("Select t from Training t", Training.class).getResultList();
		return emp;
	}
	
	@Override
	public void removeTrainingById(int trainingId) {
		// TODO Auto-generated method stub
		em.remove(em.find(Training.class, trainingId));
		
		
		
	}
	@Override
	public void updateTraining(Training training) { 
		Training emp = em.find(Training.class, training.getId()); 
		emp.setName(training.getName()); 
		emp.setDate(training.getDate()); 
		emp.setDescription(training.getDescription());
		emp.setNbplace(training.getNbplace());
		
		
		 
	}

	
	
	

		
	
		
	
	
	
	
}
