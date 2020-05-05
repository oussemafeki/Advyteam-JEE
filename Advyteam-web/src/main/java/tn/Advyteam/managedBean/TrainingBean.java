package tn.Advyteam.managedBean;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tn.Advyteam.ServicesImp.TrainingService;
import tn.Advyteam.entities.Training;





@ManagedBean(name ="trainingBean")
@SessionScoped
public class TrainingBean  implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String description;
    

	
	private String name;
	private Date date;
	private int nbplace;
	


	private List<Training> trainings;
	private Integer trainingIdToBeUpdated;

	@EJB
	TrainingService TrainingService;

	public void addTraining() { 
		TrainingService.addTraining(new Training(name, date , description,nbplace));
		
	}
	public void removeTraining(int trainingId)
	{
		TrainingService.removeTrainingById(trainingId);
	}
	
	
	
	
	
	public void displayTraining(Training training)
	{
		this.setName(training.getName());
		this.setDate(training.getDate());
		this.setDescription(training.getDescription());
		this.setNbplace(training.getNbplace());
	
		this.setTrainingIdToBeUpdated(training.getId());
		
	}
	public void updateTraining()
	{ TrainingService.updateTraining(new Training(trainingIdToBeUpdated, name, date,
	description,nbplace)); }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public int getNbplace() {
		return nbplace;
	}
	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TrainingService getTrainingService() {
		return TrainingService;
	}

	public void setTrainingService(TrainingService trainingService) {
		TrainingService = trainingService;
	}




	public List<Training> getTrainings() {
		 trainings = TrainingService.getAllTrainings();
		 return  trainings;
	}
	
	
	
	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	public Integer getTrainingIdToBeUpdated() {
		return trainingIdToBeUpdated;
	}
	public void setTrainingIdToBeUpdated(Integer trainingIdToBeUpdated) {
		this.trainingIdToBeUpdated = trainingIdToBeUpdated;
	}
	

	
	}

	
	


