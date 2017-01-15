package com.rest;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.db.Anwender;


/**
 * Created by mtc on 29.05.16.
 */
@Path("/intern/user/")
public class AnwenderResource {
    private static final Logger log = LoggerFactory.getLogger(AnwenderResource.class);

    @PersistenceContext(unitName="MyPersistenceUnit")
    private EntityManager em;

    @GET
    @Path("getUsers")
    public Response getUsers(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        log.info("Retrieving Users...");

        List<Anwender> anwenderList = em.createQuery("from Anwender").getResultList();

        log.info("getUsers success: {}", anwenderList);
        return Response.status(200).entity(anwenderList).build();
    }
}
