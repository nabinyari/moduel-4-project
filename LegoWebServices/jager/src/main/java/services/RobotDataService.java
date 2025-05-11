package services;

import data.RobotSettings;
import data.RobotStats;

import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/robot")
public class RobotDataService {

    @PersistenceContext(unitName = "LegoPU")
    EntityManager em;

    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String info()
    {
        return "this is working";
    }

    @POST
    @Path("/settings")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSettings(RobotSettings settings) {
        try {
            em.persist(settings);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLatestSettings() {
        try {
            TypedQuery<RobotSettings> query = em.createQuery(
                "SELECT r FROM RobotSettings r ORDER BY r.id DESC", RobotSettings.class);
            RobotSettings latest = query.setMaxResults(1).getSingleResult();
            return Response.ok(latest).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/stats")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveStats(RobotStats stats) {
        try {
            em.persist(stats);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/stats/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLatestStats() {
        try {
            TypedQuery<RobotStats> query = em.createQuery(
                "SELECT s FROM RobotStats s ORDER BY s.id DESC", RobotStats.class);
            RobotStats latest = query.setMaxResults(1).getSingleResult();
            return Response.ok(latest).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
