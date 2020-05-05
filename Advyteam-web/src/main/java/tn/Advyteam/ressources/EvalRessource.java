package tn.Advyteam.ressources;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.Advyteam.ServicesImp.CritereService;
import tn.Advyteam.ServicesImp.SelfEvalService;



@Path("evals")
@RequestScoped
public class EvalRessource {
	@EJB
	SelfEvalService ses;
	@EJB
	CritereService cs ;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSelfEvals()
	{
	return Response.ok(ses.getAllSelfEvals(1)).build()	;
	}
	@GET
	@Path("{iduser}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getcriterebyuser(@PathParam(value="iduser")int iduser) {
		
		return Response.ok(cs.getAllCriteresByUser(iduser)).build();
	}
	
}
