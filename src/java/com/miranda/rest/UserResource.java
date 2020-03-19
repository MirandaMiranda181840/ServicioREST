/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miranda.rest;

import com.miranda.entidades.User;
import com.miranda.servicio.UserServicio;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author miran
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
  
        try {

            List<User> users = new UserServicio().getAll();

            String json = new Gson().toJson(users);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();

        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
            
        try{
            
            System.out.println("addUser: " + user);
            
            UserServicio service = new UserServicio();
            
            service.create(user);
            
            user = service.get(user);
            
            String json = "{\"id\":\"" + user.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
            
        }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
        
    }
    
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user, @PathParam("id") int id){
         
        try{
        
            System.out.println("updateUser. User: " + user);
            
            user.setId(id);
            
            new UserServicio().update(user);
            
            String json = "{\"id\":\""+user.getId()+"\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
            
        }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
        
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") int id){
        
        try{
            
            System.out.println("deleteUser. User: " + id);
            
            User user = new User();
            
            user.setId(id);
            
            new UserServicio().delete(user);
            
            String json = "{\"id\":\"" + user.getId() + "\"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
            
        }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
        
    }
    
}
/*
try{
            
        }catch(Exception e){
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
*/