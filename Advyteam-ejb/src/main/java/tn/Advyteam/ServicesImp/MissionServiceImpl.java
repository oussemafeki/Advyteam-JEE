package tn.Advyteam.ServicesImp;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.IMissionServiceRemote;
import tn.Advyteam.entities.Demande;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Expenses;
import tn.Advyteam.entities.Mission;
import tn.Advyteam.entities.Project;
import tn.Advyteam.entities.Skills;



@Stateless
@LocalBean
public class MissionServiceImpl implements IMissionServiceRemote {
	@PersistenceContext
	EntityManager em;

	@Override
	public Mission addMission(Mission mission, Project p, Expenses e) {
		//mission.setMissionSkill(s);
		mission.setExpense(e);
		mission.setProjet(p);
		
		em.persist(mission);
		
		return mission;
	}

	@Override
	public Mission createMission(Mission mission, Project p) {
		//mission.setMissionSkill(s);
		mission.setProjet(p);
		
		em.persist(mission);
		
		return mission;
	}
	@Override
	public Long createExpense(Expenses e) {
		// TODO Auto-generated method stub
		
		System.out.println("2222222222222222222222222222222222222222");
		em.persist(e);
		
		
		return e.getId();	}

	@Override
	public void deleteMissionById(Long missionId) {
		Mission mission = em.find(Mission.class, missionId);
		em.remove(mission);
		
	}
	public void deleteDemandeById(Long missionId) {
		Demande mission = em.find(Demande.class, missionId);
		em.remove(mission);
		
	}

	@Override
	public void updateMission(Mission mission,String nomMision) {
		Mission m = new Mission();
		try {
			Query query = em.createQuery("select e from Mission e where e.nomMission=:nom");
			query.setParameter("nom", nomMision);

			m = (Mission) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("no data found");
		}
		if (m != null) {
			
			m.setNomMission(mission.getNomMission());
			m.setDateDeb(mission.getDateDeb());
			m.setDateFin(mission.getDateFin());
			m.setExpense(mission.getExpense());
			m.setAdresse(mission.getAdresse());
			m.setType(mission.getType());
			em.merge(m);
			
		}}
		@Override
		public void affectExpense(Mission mission,long id) {
			Expenses m = new Expenses();
			try {
				Query query = em.createQuery("select e from Expenses e where e.id=:id");
				query.setParameter("id", id);

				m = (Expenses) query.getSingleResult();
			} catch (Exception e) {
				System.out.println("no data found");
			}
			if (m != null) {
				
				mission.setExpense(mission.getExpense());
				em.merge(mission);
				
			}
			
	
	}

	@Override
	public void valideMission(int missionId) {
		// TODO Auto-generated method stub

	}
	/*@Override
	public void updateMission(Mission e) {
		em.merge(e);
		
	}*/
	@Override
	public void approveMission(Demande e) {
		System.out.println("hhhhhhhhhhhhh");
		e.setIsValide(true);
		em.merge(e);
		
	}
	@Override
	public void refuseMission(Demande e) {
		System.out.println("hhhhhhhhhhhhh");
		e.setIsValide(false);
		em.merge(e);
		
	}
	
	@Override
	public void etatMission(Demande e) {
		System.out.println("hhhhhhhhhhhhh");
		e.setEtat("Done");
		em.merge(e);
		
	}
	@Override
	public List<Mission> getAllMissions() {
		/*List<Mission> mission = em.createQuery("Select e from Mission e",
				Mission.class).getResultList();
				return mission;*/
TypedQuery<Mission> query=em.createQuery("Select e from Mission e",
		Mission.class);
List<Mission> mission=query.getResultList();
return mission;
		}

	@Override
	public List<Demande> getAllDemande() {
		List<Demande> d = em.createQuery("Select e from Demande e",
				Demande.class).getResultList();
				return d;
	}

	@Override
	public void affecterEmployeAMission(int employeeId, int missionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		List<Project> project = em.createQuery("Select e from Project e", Project.class).getResultList();
		return project;
	}

	@Override
	public List<Expenses> getAllExpenses() {
		// TODO Auto-generated method stub
		List<Expenses> expense = em.createQuery("Select e from Expenses e", Expenses.class).getResultList();
		return expense;
	}

	@Override
	public List<Skills> getAllSkills() {
		// TODO Auto-generated method stub
		List<Skills> skill = em.createQuery("Select e from Skills e", Skills.class).getResultList();
		return skill;
	}

	@Override
	public List<Mission> getAllMissionsValide() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Mission> getMissionsByProject(long projectId) {
		Project projectManagedEntity = em.find(Project.class, projectId);
		System.out.println("userManagedEntity.getProjects().size() : " + projectManagedEntity.getMissions().size());
		System.out.println("userManagedEntity.getProjects().get(0).getDescription() : "
				+ projectManagedEntity.getMissions().get(0).getDescription());

		return projectManagedEntity.getMissions().stream().sorted((a, b) -> {
			return a.getDateDeb().compareTo(b.getDateFin());
		}).collect(Collectors.toList());
	}

	@Override
	public Mission getMissionById(long id) {
		TypedQuery<Mission> query = em.createQuery("select u from Mission u WHERE u.id=:id ", Mission.class);
		query.setParameter("id", id);
		Mission mission = null;
		try {
			mission = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return mission;
	}
	
	
	public Employe getEmplById(int id) {
		TypedQuery<Employe> query = em.createQuery("select u from Employe u WHERE u.id=:id ", Employe.class);
		query.setParameter("id", id);
		Employe employee=new Employe();
		try {
			employee = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employee;
	}
	
	public Demande getDemandeById(long id) {
		TypedQuery<Demande> query = em.createQuery("select u from Demande u WHERE u.id=:id ", Demande.class);
		query.setParameter("id", id);
		Demande mission = null;
		try {
			mission = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return mission;
	}
	public Employe getEmployeById(long id) {
		TypedQuery<Employe> query = em.createQuery("select u from Employe u WHERE u.id=:id ", Employe.class);
		query.setParameter("id", id);
		Employe mission = null;
		try {
			mission = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return mission;
		}
	@Override
	public Mission getMissionByName(String nomMission) {
		TypedQuery<Mission> query = em.createQuery("select u from Mission u WHERE u.nomMission=:nomMission ", Mission.class);
		query.setParameter("nomMission", nomMission);
		Mission mission = null;
		try {
			mission = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return mission;
	}
	public Project getProjectByName(String nomProj) {
		TypedQuery<Project> query = em.createQuery("SELECT c FROM Project c WHERE c.title=:nomProj", Project.class);
		query.setParameter("nomProj", nomProj);

		Project pr = null;
		try {
			pr = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}

		return pr;
	}
	@Override
	public List<Mission> getDemandesByProject(long projectId) {
		Project projectManagedEntity = em.find(Project.class, projectId);
		System.out.println("userManagedEntity.getProjects().size() : " + projectManagedEntity.getMissions().size());
		System.out.println("userManagedEntity.getProjects().get(0).getDescription() : "
				+ projectManagedEntity.getMissions().get(0).getDemandes());

		return projectManagedEntity.getMissions().stream().sorted((a, b) -> {
			return a.getDateDeb().compareTo(b.getDateDeb());
		}).collect(Collectors.toList());
	}
@Override
	public Project getProjectByID(Long projectId) {
		TypedQuery<Project> query = em.createQuery("SELECT c FROM Project c WHERE c.id=:projectId", Project.class);

		query.setParameter("projectId", projectId);
		Project pr = null;
		try {
			pr = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur :+e");
		}
		return pr;

	}

	public Expenses getExpenseByName(String t) {
		TypedQuery<Expenses> query = em.createQuery("SELECT c FROM Expenses c WHERE c.title=:t", Expenses.class);
		query.setParameter("t", t);

		Expenses ex = null;
		try {
			ex = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}

		return ex;
	}

	@Override
	public Long addExpenses(Expenses e,Mission mission) {
		// TODO Auto-generated method stub
		e.setTotal(e.getAutres_frais()+e.getPrix_hebergement()+(e.getDistance()*e.getPrix_transport())+e.getPrix_resto());
		System.out.println("2222222222222222222222222222222222222222");
		em.persist(e);
		System.out.println(mission);
		mission.setExpense(e);
		System.out.println("555555555555555555555555");
		em.merge(mission);
		System.out.println(mission);
		return e.getId();	}

	@Override
	public Long addMission1(Mission mission) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteMissionById(int missionId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void requestMission(Demande d,Employe emp,Mission mission) {
		System.out.println(mission);
		System.out.println(emp);
		d.setEmploye(emp);
		d.setMission(mission);
		d.setEtat("Waiting");
		d.setIsValide(false);
		System.out.println(d);
		em.persist(d);
	}



	@Override
	public void dropMissionById(Long missionId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateMission(Mission e) {
		// TODO Auto-generated method stub
		em.merge(e);
		
	}



	/*@Override
	public Mission getMissionById(int id) {
	
		Mission cr = em.find(Mission.class, id);
		return cr;
	}
	
*/


	/*public Skills getSkillByName(String sk) {
		TypedQuery<Skills> query = em.createQuery("SELECT c FROM Skills c WHERE c.Skillname=:sk", Skills.class);
		query.setParameter("sk", sk);

		Skills s = null;
		try {
			s = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}

		return s;
	}
*/
}
