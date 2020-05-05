package tn.Advyteam.IServices;



import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Training;







@Remote
public interface ITrainingService {
	
	public int addTraining(Training training);
	public List<Training> getAllTrainings();
	public void removeTrainingById(int trainingId);
	public void updateTraining(Training training);
	
	public Training findById(int idTest);
	
	

}
