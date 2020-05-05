package tn.Advyteam.ressources;

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

import tn.Advyteam.ServicesImp.TachesServiceRemoteImp;
import tn.Advyteam.entities.Project;
import tn.Advyteam.entities.Taches;

@Path("/taches")
@RequestScoped
public class TacheRessources {

	@EJB
	TachesServiceRemoteImp tacheService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTaches() {
		return Response.status(Status.OK).entity(tacheService.getAllTaches()).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addtache(Taches t) {
		
		tacheService.addTache(t);
		return Response.status(Status.CREATED).entity("tache ajoute !").build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteTache(@PathParam(value="id")int id )
	{
		if(tacheService.findTacheById(id)== null) {
			return Response.status(Status.NOT_FOUND).entity("tache non supprimé !").build();
		}else {
		tacheService.removeTache(id);
		return Response.status(Status.FOUND).entity("tache supprimé !").build();}
	}
/*	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchTache(@PathParam(value="id")int id) {
		if(tacheService.findTacheById(id)== null) {
			return Response.status(Status.NOT_FOUND).entity("tache introuvable").build();
		}else {
		return Response.status(Status.FOUND).entity(tacheService.findTacheById(id)).build();
	}}*/
	@PUT

	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTache(Taches p) {
		Taches t= tacheService.findTacheById(p.getId());
		tacheService.updateTache(p);
		return Response.ok(Status.FOUND).entity("tache modifié !").build();
	}
	@GET
	@Path("/tachesByModules/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTachesByModules(@PathParam("id")int id) {
		
		if(tacheService.getTacheModule(id)==null) {
	
		return Response.status(Status.NOT_FOUND).entity("ce module ne contient pas des taches").build();
		}else {
			return Response.status(Status.FOUND).entity(tacheService.getTacheModule(id)).build();	
		}
	}
}
