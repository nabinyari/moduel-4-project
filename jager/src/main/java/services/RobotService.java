package services;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import data.Robot;

@Path("/robotservice")
public class RobotService {
//Reading all the rows from table robot.
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Robot> readAllRobot() {
	//Create an EntityManagerFactory with the settings from persistence.xml file
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jagare");
		//And then EntityManager, which can manage the entities.
		EntityManager em=emf.createEntityManager();
		
		//Read all the rows from table prey. Here the Prey must start with capital, 
		//because class's name starts. This returns a List of Prey objects.
		List<Robot> list=em.createQuery("select a from Robot a").getResultList();
		return list;
	}
	
//Adding one robot object into the table robot	
	@POST
	@Path("/addrobot")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Robot postRobot(Robot robot) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("jagare");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(robot);//The actual insertion line
		em.getTransaction().commit();
		return robot;
	}
}