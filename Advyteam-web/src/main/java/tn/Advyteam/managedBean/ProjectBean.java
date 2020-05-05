
package tn.Advyteam.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.Advyteam.ServicesImp.ModulesServiceRemoteImp;
import tn.Advyteam.ServicesImp.ProjectServiceRemoteImp;
import tn.Advyteam.entities.Modules;
import tn.Advyteam.entities.Project;

@ManagedBean(name = "projectBean")
@ViewScoped
public class ProjectBean {
	private String title;
	private String description;
	private Project project;
	private List<Project> projects;
	private List<Modules> modules;
	@EJB
	ProjectServiceRemoteImp projectService;

	@ManagedProperty(value = "#{detailProjetBean}")
	DetailProjetBean detailProjetBean;

	@ManagedProperty(value = "#{updateProjectBean}")
	UpdateProjetBean updateProjetBean;

	@ManagedProperty(value = "#{ajoutProjetBean}")
	AjoutProjectBean ajoutProjectBean;

	@EJB
	ModulesServiceRemoteImp moduleService;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@PostConstruct
	public void init() {
		projects = projectService.getAllProjects();
	}

	public String updateProject(Project p) {
		updateProjetBean.setProject(p);
		updateProjetBean.init();
		return "updateProject";
	}

	public void removeProject(int id) {

		projectService.removeProject(id);
		projects = projectService.getAllProjects();
	}

	public String goToAddPage() {
		ajoutProjectBean.init();
		return "goToAddProject";
	}

	public String goToDetails(Project p) {
		detailProjetBean.setProject(p);
		detailProjetBean.init();
		return "goToDetailsProjet";
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Modules> getModules() {
		return modules;
	}

	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}

	public void setDetailProjetBean(DetailProjetBean detailProjetBean) {
		this.detailProjetBean = detailProjetBean;
	}

	public void setAjoutProjectBean(AjoutProjectBean ajoutProjectBean) {
		this.ajoutProjectBean = ajoutProjectBean;
	}

	public String updateprojectsmethode() {
		projectService.updateProject(new Project(title, description));
		return "goToFarah";
	}

	public void setUpdateProjetBean(UpdateProjetBean updateProjetBean) {
		this.updateProjetBean = updateProjetBean;
	}

}
