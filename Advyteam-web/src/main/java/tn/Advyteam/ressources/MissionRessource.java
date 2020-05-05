package tn.Advyteam.ressources;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.Advyteam.ServicesImp.MissionServiceImpl;
import tn.Advyteam.entities.Demande;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Expenses;
import tn.Advyteam.entities.Mission;
import tn.Advyteam.entities.Project;



@Path("missions")
@RequestScoped
public class MissionRessource 
{

	@EJB MissionServiceImpl serviceMission;

	//-------------------------

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCandidat(Mission m,@QueryParam(value="nomProj")String nomProj    ) {

		System.out.println("entrer");
		Project p = serviceMission.getProjectByName(nomProj);
		m.setProjet(p);

		serviceMission.addExpenses(m.getExpense(), m);
		return Response.status(Status.CREATED).entity("add successful!").build();
	}
	
	@POST
	@Path("creationMission")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creationMission(Mission m,@QueryParam(value="nomProj")String nomProj    ) {

		System.out.println("entrer");
		Project p = serviceMission.getProjectByName(nomProj);
		m.setProjet(p);
		serviceMission.createMission(m, p);
		//serviceMission.addExpenses(m.getExpense(), m);
		return Response.status(Status.CREATED).entity("add successful!").build();
	}
	@POST
	@Path("creationExpense")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creationMission(Expenses e) {

		System.out.println("entrer");
		serviceMission.createExpense(e);
		//serviceMission.addExpenses(m.getExpense(), m);
		return Response.status(Status.CREATED).entity("add successful!").build();
	}
	//demande mission
	@POST
	@Path("demandeAdd")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response demandeMission(Demande d,@QueryParam(value="mission_id")long mission_id    ) {

		System.out.println("entrer");
		
		Mission m ;
		Employe em =new Employe();
		em.setId(1);

		m=serviceMission.getMissionById(mission_id);
		System.out.println("m");

		System.out.println(m);
		

		System.out.println("test"); //  
		serviceMission.requestMission(d, em, m);
		
		return Response.status(Status.CREATED).entity(serviceMission.getAllDemande()).build();
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpCandidat(Mission m,@QueryParam(value="nomMission")String nomMission    ) {

		
				serviceMission.updateMission(m, nomMission);
				return Response.status(Status.CREATED).entity("votre Candidat a ete modifee avec success !").build();
		
	}
	
//-------------------------
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMissions(@QueryParam(value="nomMission")String nomMission )
	{		System.out.println("wiem");

		System.out.println("testtttttttttttttt");
	if(nomMission==null)
	{
	return Response.status(Status.OK).entity(serviceMission.getAllMissions()).build();
	}
	List<Mission> ListeMissions=serviceMission.getAllMissions();
	System.out.println("declare");

	for (Mission e : ListeMissions) {
		System.out.println("boucle");

	if (e.getNomMission().equals(nomMission)) {
	System.out.println("found ");

	return Response.status(Status.FOUND).entity(e).build();
	
	}
	}
	
	return Response.status(Status.NOT_FOUND).entity("votre Mission n'est pas trouvée").build(); 
	}
	@GET
	@Path("demande")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDemandes()
	{		System.out.println("wiem");
	return Response.status(Status.OK).entity(serviceMission.getAllDemande()).build();

		
	}
	@GET
	@Path("expense")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExpense()
	{		System.out.println("wiem");
	return Response.status(Status.OK).entity(serviceMission.getAllExpenses()).build();

		
	}

	//-------------------------
	@POST
	@Path("modifier")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateCandidat(@PathParam(value = "nomMission") String nomMission, Mission e) {
		System.out.println("zzzzzzzzzzzzzzzzzzzz");
		List<Mission> ListeMissions=serviceMission.getAllMissions();
		System.out.println("aaaaaaaaaaa");

		for (int i = 0; i < ListeMissions.size(); i++) {
			System.out.println("d5al  lel boucle");
			if (ListeMissions.get(i).getNomMission().equals(nomMission)) {
				System.out.println("l9ah");
				serviceMission.updateMission(e);
				return Response.status(Status.CREATED).entity("votre Candidat a ete modifee avec success !").build();
			}
		}
		return Response.status(Status.NOT_MODIFIED).entity("votre Candidat est introuvable !").build();
	}
	@POST
	@Path("affecterExpense/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response affecterExpense(@PathParam(value = "id") long id, Mission e) {
		System.out.println("zzzzzzzzzzzzzzzzzzzz");
		List<Mission> ListeMissions=serviceMission.getAllMissions();
		System.out.println("aaaaaaaaaaa");

		for (int i = 0; i < ListeMissions.size(); i++) {
			System.out.println("d5al  lel boucle");
			if (ListeMissions.get(i).getId()==id) {
				System.out.println("l9ah");
				serviceMission.affectExpense(e, id);
				return Response.status(Status.CREATED).entity("votre Candidat a ete modifee avec success !").build();
			}
		}
		return Response.status(Status.NOT_MODIFIED).entity("votre Candidat est introuvable !").build();
	}

	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response DeleteCandidat(@PathParam(value = "id") long id) {
		List<Mission> ListeMissions=serviceMission.getAllMissions();
		System.out.println("IN");

		for (Mission e : ListeMissions) {
			if (e.getId()==id) {
				serviceMission.deleteMissionById(e.getId());
				return Response.status(Status.GONE).entity("Candidat supprimee !").build();
			}

		}
		return Response.status(Status.NOT_FOUND).entity("votre Candidat n'est pas trouvée").build();
	}
}