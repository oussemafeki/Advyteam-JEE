package tn.Advyteam.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.Advyteam.ServicesImp.AffectationProjectServiceImpl;
import tn.Advyteam.ServicesImp.ProjectServiceRemoteImp;
import tn.Advyteam.ServicesImp.UserServiceRemoteImpl;
import tn.Advyteam.entities.AffectationProject;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Project;


@ManagedBean(name = "updateProjectBean")
@SessionScoped
public class UpdateProjetBean {

	public Project project;

	private List<Employe> users;

	private List<Employe> selectedUsers;
	
	private String title;
	
	private String description;

	@EJB
	ProjectServiceRemoteImp projectService;
	
	@EJB
	UserServiceRemoteImpl userService;
	
	@EJB
	AffectationProjectServiceImpl affectationProjectService;
	
	public void init() {
		selectedUsers = new ArrayList<Employe>();
		users = userService.getAllUsers();
		if(project != null) {
			title = project.getTitle();
			description = project.getDescription();
		}
	}

	public String update() {
		project.setTitle(title);
		project.setDescription(description);
		projectService.updateProject(project);
		
		for(Employe u : selectedUsers) {
			AffectationProject affProjet = new AffectationProject();
			affProjet.setDateAffectation(new Date());
			affProjet.setProjetaffectation(project);
			affProjet.setUseraffectation(u);
			affectationProjectService.update(affProjet);
		}
		return "goToFarah";
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

}
