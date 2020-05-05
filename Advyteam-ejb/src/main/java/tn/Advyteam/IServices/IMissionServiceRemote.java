package tn.Advyteam.IServices;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Demande;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Expenses;
import tn.Advyteam.entities.Mission;
import tn.Advyteam.entities.Project;
import tn.Advyteam.entities.Skills;



@Remote
public interface IMissionServiceRemote {
	public void deleteMissionById(int missionId);
	public void valideMission(int missionId);

	public void affecterEmployeAMission(int employeeId, int missionId);
	public List<Project> getAllProjects();
	//public List<Mission> getMissionsByProject(int projectId) ;
	public List<Mission> getAllMissionsValide();
	List<Expenses> getAllExpenses();
	List<Skills> getAllSkills();
	public Long addMission1(Mission mission);
	Mission addMission(Mission mission, Project p, Expenses e);
	//Long addExpenses(Expenses e);
	public List<Mission> getAllMissions();
	void deleteMissionById(Long missionId);
	void updateMission(Mission e);
	//void requestMission(int empId, long missionId);
	//void requestMission(Demande d);
	void requestMission(Demande d, Employe emp, Mission mission);
	Long addExpenses(Expenses e, Mission mission);
	List<Demande> getAllDemande();
	void approveMission(Demande e);
	void etatMission(Demande e);
	void dropMissionById(Long missionId);
	void refuseMission(Demande e);
	//Mission getMissionById(int id);
	void updateMission(Mission mission, String nomMision);
	Mission getMissionByName(String nomMission);
	List<Mission> getDemandesByProject(long projectId);
	Project getProjectByID(Long projectId);
	Mission getMissionById(long id);
	Mission createMission(Mission mission, Project p);
	Long createExpense(Expenses e);
	void affectExpense(Mission mission, long id_expense);
}