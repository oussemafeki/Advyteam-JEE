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

import tn.Advyteam.IServices.ITrainingService;
import tn.Advyteam.entities.Training;








@Path("training")
@RequestScoped
public class TrainingRessources
{
	
	@EJB
	ITrainingService TrainingService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTraining() { 
		return Response.ok(TrainingService.getAllTrainings()).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTest(Training t) {
		TrainingService.addTraining(t);
		return Response.status(Status.CREATED).entity(t).build(); 
	}
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTrainings() {
//		List<Test> list=null;
//		for (Test test : TestService.getAllTests()) {
//			list.add(test);
//		}
		return Response.status(Status.OK).entity(TrainingService.getAllTrainings()).build();
	}
	*/
	/*
//Liste Statique 
	public static List<Training> listeTrainings=new ArrayList<Training>();
	

	//(A) Ajouter un Employe 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayEmployeesList() {	
		return Response.status(Status.OK).entity("trainings"+this.listeTrainings).build();
	}

*/
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Response updateTest(Training t) {
		TrainingService.updateTraining(t);
		return Response.status(Status.OK).entity(t).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam(value="id") int idTest) {
		return Response.status(Status.OK).entity(TrainingService.findById(idTest)).build();
	}


	@DELETE
	@Path("{id}")
	
	public Response deleteTest(@PathParam(value="id") int idTest) {
		TrainingService.removeTrainingById(idTest);
		return Response.status(Status.OK).entity("test removed").build();
	}

}
