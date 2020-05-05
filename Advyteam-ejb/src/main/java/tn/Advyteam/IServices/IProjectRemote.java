package tn.Advyteam.IServices;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Project;



@Remote
public interface IProjectRemote {
	public int addProject (Project project);
	public List<Project> getAllProjects() ;
	public void removeProject(int id);
	public void updateProject(Project project);
	public Project findProjectById(int id);
	List<Project> findProjectsByUser(int iduser);
}
