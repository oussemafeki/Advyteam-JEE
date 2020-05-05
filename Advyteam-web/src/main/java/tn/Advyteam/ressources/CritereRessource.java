package tn.Advyteam.ressources;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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

import tn.Advyteam.ServicesImp.CritereService;
import tn.Advyteam.entities.Critere;

@Path("critere")
@RequestScoped
public class CritereRessource {
	@EJB
	CritereService cs;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCriteres()
	{
	return Response.ok(cs.getAllCriteres()).build()	;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCritere(Critere critere)
	{
		
		return Response.ok(cs.ajouterCritere(critere)).build();
	}
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteCritere(@PathParam(value="id")int id )
	{
		cs.deleteCritereById(id);
		return Response.status(Status.FOUND).entity("critere supprimee !").build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchCritere(@PathParam(value="id")int id) {
		
		return Response.ok(cs.getCritereById(id)).build();
	}
	
}
