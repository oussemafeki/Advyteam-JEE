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

import tn.Advyteam.ServicesImp.PosteService;
import tn.Advyteam.entities.Poste;

@Path("poste")
@RequestScoped
public class PosteRessource {
	@EJB
	PosteService ps;
	
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPostByID(@PathParam(value="id")int id )
	{
		ps.findPosteById(id);
		return Response.status(Status.FOUND).entity("competance supprimee !").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPoste()
	{
	return Response.ok(ps.getAllPoste()).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPoste(Poste poste)
	{
		return Response.ok(ps.addPoste(poste)).build();
	}
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeletePoste(@PathParam(value="id")int id )
	{
		ps.removePoste(id);
		return Response.status(Status.FOUND).entity("poste supprimee !").build();
	}

}
