package tn.Advyteam.managedBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.Advyteam.ServicesImp.MissionServiceImpl;
import tn.Advyteam.entities.Demande;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Expenses;
import tn.Advyteam.entities.Mission;
import tn.Advyteam.entities.Project;



@ManagedBean(name = "missionBean")
@SessionScoped

public class MissionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomMission;
	private String nomProj;
	private String t;
	private String sk;
	private String searchName = "";

	private String description;
	private String adresse;
	private Date dateDeb;
	private Date dateFin;
	private String type;
	private List<Demande> demandes;
	private Project project;
	private List<Project> projects;
	private Expenses expense;
	private List<Expenses> expenses;
	private List<Mission> missions;
	private List<Mission> missionsFiltre;
	private List<Demande> demande;

	private Mission mission;
	private Demande dem;

	@EJB
	private MissionServiceImpl missionService;

	public String updateMissionInit(Mission e) {

		this.mission = e;

		return "UpdateMission?faces-redirect=true";
	}
	

	public Demande getDem() {
		return dem;
	}


	public void setDem(Demande dem) {
		this.dem = dem;
	}


	public String UpdateMission() {
		missionService.updateMission(mission);
		return "/xhtml/afficherMissions?faces-redirect=true";
	}
	
	
    String mailFrom = "wiem.zayeti@esprit.tn";
    String password = "mot de passe";


    String subject = "Advyteam account";
    String message = "An account was created for you with this email in the advyteam plateform";

 
	public String refuserMission(Demande dem) {
		System.out.println("1111111");
this.dem=dem;
		missionService.refuseMission(dem);
	    try {
	      //  SimpleMail.sendEmailWithAttachments( mailFrom, password, "wiem.zayeti@esprit.tn",subject, message);
	        System.out.println("Email sent.");
	    } catch (Exception ex) {
	        System.out.println("Could not send email.");
	        ex.printStackTrace();
	    }

		return "/xhtml/afficherDemande?faces-redirect=true";
	}

    
	public String approveMission(Demande dem) {
		System.out.println("1111111");
this.dem=dem;
		missionService.approveMission(dem);
		return "/xhtml/afficherDemande?faces-redirect=true";
	}
	public String terminerMission(Demande dem) {
		System.out.println("1111111");
		if(dem.getEtat()=="Done")
		{this.dem=dem;
		System.out.println("2222222222222");

		missionService.etatMission(dem);}
		return "/xhtml/afficherDemande?faces-redirect=true";
	}
	public List<Mission> getMissionsFiltre() {
		return missionsFiltre;
	}

	public void setMissionsFiltre(List<Mission> missionsFiltre) {
		this.missionsFiltre = missionsFiltre;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	

	
	public String backToAdd(){
		this.mission = new Mission();
		this.searchName="";
		return "ajouterMission?faces-redirect=true";
	}
	public List<Mission> filterListFront() {

		for (Mission miss : missionService.getAllMissions()) {
			System.out.println(miss);
			if (miss.getDateFin().after(new Date())) {
				missionsFiltre.add(miss);

			}
		}
		return missionsFiltre;

	}
	public String addMission() {
 System.out.println("innnnnnnnn");
		// missionSkill = missionService.getSkillByName(sk);
		expense = missionService.getExpenseByName(t);
		project = missionService.getProjectByName(nomProj);
		System.out.println(nomProj);
		System.out.println(project + "-project-");
		System.out.println(t);
		System.out.println(expense + "-expense-");
		mission = new Mission(nomMission, description, adresse, dateDeb, dateFin, type);
		this.mission=missionService.addMission(mission, project,
				expense);
		
		return "/xhtml/remplireExpense?faces-redirect=true";

	}

	public String addRequest(Mission mission) {
		Employe e = new Employe();
		e.setId(1);
		System.out.println("hhhhhhhhhhhhhhhhhhhhhh");
		missionService.requestMission(new Demande("Waiting", false),e,mission);
		return "/xhtml/afficherDemande?faces-redirect=true";

	}

	public List<Project> getAll_Projects() {
		projects = missionService.getAllProjects();
		return projects;
	}

	public List<Expenses> getAll_Expenses() {
		expenses = missionService.getAllExpenses();
		return expenses;
	}

	public String removeMission(Long missionId) {
		missionService.deleteMissionById(missionId);
		return "/xhtml/afficherMissions?faces-redirect=true";
	}

	public List<Mission> getMissions() {
		missions = missionService.getAllMissions();
		return missions;
	}
	public List<Demande> getDemandes() {
		demande = missionService.getAllDemande();
		return demande;
	}
	
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	@Override
	public String toString() {
		return "MissionBean [projects=" + projects + "]";
	}

	public String getNomMission() {
		return nomMission;
	}

	public void setNomMission(String nomMission) {
		this.nomMission = nomMission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Expenses getExpense() {
		return expense;
	}

	public void setExpense(Expenses expense) {
		this.expense = expense;
	}

	public String getSk() {
		return sk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getNomProj() {
		return nomProj;
	}

	public void setNomProj(String nomProj) {
		this.nomProj = nomProj;
	}
	private String title;

	private Float distance;
	private Float prix_transport;
	private Float prix_hebergement;
	private Float prix_resto;
	private Float autres_frais;
	
	
	
	
	public String addExpenses(Mission mission) {
		System.out.println("1111111111111111111111111111111");
		// missionSkill = missionService.getSkillByName(sk);
		Expenses expense= new Expenses(title,distance, prix_transport, prix_hebergement, prix_resto, autres_frais);
		 missionService.addExpenses(expense,mission);
			//return "http://localhost:25355/mission";

		 
		return "/xhtml/afficherMissions?faces-redirect=true";
		
 
	}
	private Long missionIdToBeUpdated;
	
	public Long getMissionIdToBeUpdated() {
		return missionIdToBeUpdated;
	}

/*
	public void setMissionIdToBeUpdated(Long missionIdToBeUpdated) {
		this.missionIdToBeUpdated = missionIdToBeUpdated;
	}
*/
/*
	public String displayMission(Mission m1) {
		this.setNomMission(m1.getNomMission());
		this.setExpense(m1.getExpense());
		this.setProject(m1.getProjet());

		this.setMissionIdToBeUpdated(m1.getId());
		return "detailMission?faces-redirect=true";
}
	


	*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}
	public Float getPrix_transport() {
		return prix_transport;
	}
	public void setPrix_transport(Float prix_transport) {
		this.prix_transport = prix_transport;
	}
	public Float getPrix_hebergement() {
		return prix_hebergement;
	}
	public void setPrix_hebergement(Float prix_hebergement) {
		this.prix_hebergement = prix_hebergement;
	}
	public Float getPrix_resto() {
		return prix_resto;
	}
	public void setPrix_resto(Float prix_resto) {
		this.prix_resto = prix_resto;
	}
	public Float getAutres_frais() {
		return autres_frais;
	}
	public void setAutres_frais(Float autres_frais) {
		this.autres_frais = autres_frais;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	

}
