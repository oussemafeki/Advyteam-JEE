package tn.Advyteam.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.Advyteam.ServicesImp.AffectationProjectServiceImpl;
import tn.Advyteam.ServicesImp.ProjectServiceRemoteImp;
import tn.Advyteam.ServicesImp.UserServiceRemoteImpl;
import tn.Advyteam.entities.AffectationProject;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Modules;
import tn.Advyteam.entities.Project;

@ManagedBean(name = "ajoutProjetBean")
@SessionScoped
public class AjoutProjectBean {

	
	
	private List<Project> projects;
	
	
	private String title;
	
	private String description;
	
	private List<Employe> users;
	
	private List<Employe> selectedUsers;
	
	@EJB
	ProjectServiceRemoteImp projectService;
	
	@EJB
	UserServiceRemoteImpl userService;
	
	@EJB
	AffectationProjectServiceImpl affectationProjectService;
	
	
	public void init() {
		selectedUsers = new ArrayList<Employe>();
		users = userService.getAllUsers();
	}
	
	public String saveproject() {
		Project p = new Project(title, description);
		int id = projectService.addProject(p);
		p.setId(id);
		for(Employe u : selectedUsers) {
			AffectationProject affProjet = new AffectationProject();
			affProjet.setDateAffectation(new Date());
			affProjet.setProjetaffectation(p);
			affProjet.setUseraffectation(u);
			affectationProjectService.save(affProjet);
		}
		

		return "goToFarah";
	}
	
	public String back() {
		return "goToFarah";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employe> getUsers() {
		return users;
	}

	public void setUsers(List<Employe> users) {
		this.users = users;
	}

	public List<Employe> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<Employe> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
	
	
}
