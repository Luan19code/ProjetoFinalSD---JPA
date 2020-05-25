/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.sd.WS;

import br.edu.fafic.sd.model.Autor;
import br.edu.fafic.sd.model.Livro;
import br.edu.fafic.sd.services.Servicos;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author luanl
 */
@Path("/livro")
public class LivroWS {

    private final Servicos ps = new Servicos();

    @POST
    public Response salvarLivro(Livro l) {
        ps.saveLivro(l);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Response FindByID(@PathParam("id") long id) {
        Livro l = ps.findById(id);
        return Response.status(Response.Status.CREATED).entity(l).build();
    }
    
    @GET
    @Path("consuntar/{titulo}")
    public Response buscarTitulo(@PathParam("titulo") String livro) {
        Livro l = ps.getTitulo(livro);
        return Response.status(Response.Status.CREATED).entity(l).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") long id) {
        Livro l = ps.findById(id);
        ps.deletar(l);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") long id) {
        Livro l = ps.findById(id);
        ps.saveLivro(l);
        return Response.status(Response.Status.CREATED).build();
    }
}
