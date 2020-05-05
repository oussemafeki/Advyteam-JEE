package tn.Advyteam.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.Advyteam.ServicesImp.UserServiceRemoteImpl;

@Path("user")
@RequestScoped
public class UserRessources {
	
	@EJB
	UserServiceRemoteImpl userService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTaches() {
		return Response.ok(userService.getAllUsers()).build();
	}
}
