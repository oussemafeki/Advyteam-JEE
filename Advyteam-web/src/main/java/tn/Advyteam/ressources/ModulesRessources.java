package tn.Advyteam.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.Advyteam.ServicesImp.ModulesServiceRemoteImp;

@Path("Modules")
@RequestScoped
public class ModulesRessources {
	
	@EJB
	ModulesServiceRemoteImp moduleService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTaches() {
		return Response.ok(moduleService.getAllModules()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getModuleprojet(@PathParam(value = "id")int id) {
		return Response.ok(moduleService.getModulesProjet(id)).build();
	}
}
