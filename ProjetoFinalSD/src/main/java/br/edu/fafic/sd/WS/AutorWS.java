/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.sd.WS;

import br.edu.fafic.sd.model.Autor;
import br.edu.fafic.sd.services.Servicos;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author luanl
 */
@Path("/autor")
public class AutorWS {

    private final Servicos ps = new Servicos();

    @GET
    @Path("/{id}")
    public Response FindByID_autor(@PathParam("id") long id) {
        Autor au = ps.findById_autor(id);
        return Response.status(Response.Status.CREATED).entity(au).build();
    }
    
    
}
