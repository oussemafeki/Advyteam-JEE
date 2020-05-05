package tn.Advyteam.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.Advyteam.ServicesImp.ProjectServiceRemoteImp;
import tn.Advyteam.entities.Project;

@ManagedBean(name = "listeProjectsBean")
@SessionScoped
public class ListeProjectsBean {

	private List<Project> projects;
	
	@EJB
	ProjectServiceRemoteImp projectService;
	
	@ManagedProperty(value="#{detailsTacheBean}")
	DetailsTacheBean detailsTachesBean;
	
	@PostConstruct
	public void init() {
		int idUserConnecte = 1;
		projects = projectService.findProjectsByUser(idUserConnecte);
		System.out.println("c bn c bn ");
	}
	
	public String goToDetails(Project p) {
		detailsTachesBean.setProject(p);
		detailsTachesBean.init();
		return "goToDetailsTaches";
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public DetailsTacheBean getDetailsTachesBean() {
		return detailsTachesBean;
	}

	public void setDetailsTachesBean(DetailsTacheBean detailsTachesBean) {
		this.detailsTachesBean = detailsTachesBean;
	}

	
	
}
