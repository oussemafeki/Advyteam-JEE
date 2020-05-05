package tn.Advyteam.ressources;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.Advyteam.ServicesImp.CompetanceService;
import tn.Advyteam.entities.Competance;

@Path("competance")
@RequestScoped
public class CompetRessource {
	@EJB
	CompetanceService cs;
	
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEmployeeByID(@PathParam(value="id")int id )
	{
		cs.findCompetanceById(id);
		return Response.status(Status.FOUND).entity("competance supprimee !").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompetance()
	{
	return Response.ok(cs.getAllCompetance()).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCompetance(Competance competance)
	{
		return Response.ok(cs.addCompetance(competance)).build();
	}
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteEmployee(@PathParam(value="id")int id )
	{
		cs.removeCompetance(id);
		return Response.status(Status.FOUND).entity("competance supprimee !").build();
	}

}
