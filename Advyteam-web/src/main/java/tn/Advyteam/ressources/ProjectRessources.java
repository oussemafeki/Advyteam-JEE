package tn.Advyteam.ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.Advyteam.ServicesImp.ProjectServiceRemoteImp;
import tn.Advyteam.entities.Project;

@Path("project")
@RequestScoped
public class ProjectRessources {
	//public static List<Project> ListeProject = new ArrayList<Project>();
	
	@EJB
	ProjectServiceRemoteImp projectService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProjetc() {
		return Response.ok(projectService.getAllProjects()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProject(Project p) {

		return Response.ok(projectService.addProject(p)).build();
	}
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteProject(@PathParam(value="id")int id )
	{
		projectService.removeProject(id);
		return Response.status(Status.FOUND).entity("projet supprimé !").build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchProject(@PathParam(value="id")int id) {
		
		return Response.ok(projectService.findProjectById(id)).build();
	}
	
	@GET
	@Path("/projectByUser/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProjectsByUser(@PathParam(value="id")int id) {
		return Response.ok(projectService.findProjectsByUser(id)).build();
	}
	
}
