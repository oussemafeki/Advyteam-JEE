package tn.Advyteam.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.Advyteam.ServicesImp.MissionServiceImpl;
import tn.Advyteam.entities.Demande;



@Path("rech")
@RequestScoped
public class DemandeRessource 
{

	@EJB MissionServiceImpl serviceMission;


	@GET
	@Path("mission/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchMission(@PathParam(value="id")long id) {
		
		return Response.ok(serviceMission.getMissionById(id)).build();
	}

	@GET
	@Path("projects/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Projects() {
		
		return Response.ok(serviceMission.getAllProjects()).build();
	}
	@GET
	@Path("demande/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchDemande(@PathParam(value="id")int id) {
		
		return Response.ok(serviceMission.getDemandeById(id)).build();
	}
	@DELETE
	@Path("delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Delete(@PathParam(value = "id") long id) {
		List<Demande> ListeMissions=serviceMission.getAllDemande();
		System.out.println("IN");

		for (Demande e : ListeMissions) {
			if (e.getId()==id) {
				serviceMission.deleteDemandeById(e.getId());
				return Response.status(Status.GONE).entity("Candidat supprimee !").build();
			}

		}
		return Response.status(Status.NOT_FOUND).entity("votre Candidat n'est pas trouvée").build();
	}
	@PUT
	@Path("Approuver/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Approuver(@PathParam(value = "id") long id, Demande e) {
		List<Demande> ListeMissions=serviceMission.getAllDemande();

		for (int i = 0; i < ListeMissions.size(); i++) {
			System.out.println("d5al  lel boucle");
			if (ListeMissions.get(i).getId()==id) {
				System.out.println("l9ah");
				serviceMission.approveMission(e);
				return Response.status(Status.CREATED).entity("votre Candidat a ete modifee avec success !").build();
			}
		}
		return Response.status(Status.NOT_MODIFIED).entity("votre Candidat est introuvable !").build();
	}
}