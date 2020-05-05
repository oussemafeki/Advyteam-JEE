package tn.Advyteam.ServicesImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.IProjectRemote;
import tn.Advyteam.entities.Project;


@Stateless
@LocalBean
public class ProjectServiceRemoteImp implements IProjectRemote{
	@PersistenceContext
    EntityManager em;
	@Override
	public int addProject(Project project) {
		project.setFlagActif(1);
		em.persist(project);
		return project.getId();
	}
	@Override
	public List<Project> getAllProjects() {
		TypedQuery<Project> query = em.createQuery(
				  "SELECT e FROM Project e WHERE e.flagActif ='"+1+"'", Project.class);
				List<Project> proj = query.getResultList();
		
		
		System.out.print("project :");
		return proj;
	}
	@Override
	public void removeProject(int id) {
		System.out.print(" delete delete project :");
		Project p=em.find(Project.class,id);
		p.setFlagActif(0);
	
	}
	@Override
	public void updateProject(Project project) {
		Project p=em.find(Project.class,project.getId());
		p.setTitle(project.getTitle());
		p.setDescription(project.getDescription());
		
		
		
	}
	@Override
	public Project findProjectById(int id) {
	
		return em.find(Project.class,id);
	}
	@Override
	public List<Project> findProjectsByUser(int iduser) {
		String sql = "select * from project where id in (select projetaffectation_id from affectationproject where useraffectation_id = "+iduser+")";
		Query q = em.createNativeQuery(sql,Project.class);
		List<Project> projects = q.getResultList();
		return projects;
	}

}
