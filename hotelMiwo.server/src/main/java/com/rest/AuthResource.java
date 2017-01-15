package com.rest;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.jboss.security.SecurityContextAssociation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by mtc on 29.05.16.
 */
@Path("/auth/")
public class AuthResource {
    private static final Logger log = LoggerFactory.getLogger(AuthResource.class);

    @POST
    @Path("login")
    public Response login(@FormParam("username") String username, @FormParam("password") String password, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        log.info("Performing Login...");
        try {
            request.login(username, password);

            if(request.authenticate(response)){
                log.info("Login success...");
                return Response.status(200).entity(SecurityContextAssociation.getSecurityContext().getSubjectInfo().getAuthenticatedSubject()).build();
            }
        } catch (Exception e) {
            log.error("Login Exception: " + e.getMessage());
            return Response.status(500).entity(e.getMessage()).build();
        }

        return Response.serverError().build();
    }

    @GET
    @Path("logout")
    public Response logout(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        log.info("Performing Logout...");

        try {
            request.logout();
        } catch (ServletException e) {
            log.error("Logout Exception: " + e.getMessage());
        }

        log.info("Logout success...");
        return Response.status(200).build();
    }
}
