package br.unipar.pet.dogui.resources;

import br.unipar.pet.dogui.model.ErroValidacao;
import br.unipar.pet.dogui.model.Servico;
import br.unipar.pet.dogui.service.ServicoService;
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

@Path("servico")
public class ServicosResource {
    
    //C - @POST 
    //R - @GET - GET BY ID / FIND ALL
    //U - @PUT
    //D - @DELETE
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Servico servico){
        
        try {
            
            ServicoService service = new ServicoService();
            
            return Response.ok(service.insert(servico)).build();
            
        } catch (Exception ex) {
            
            return Response.serverError().entity(
                    new ErroValidacao(ex.getMessage())).build();
        
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Servico servico) {
        try {
            
            ServicoService service = new ServicoService();
            
            return Response.ok(service.update(servico)).build();
            
        } catch (Exception ex) {
            
            return Response.serverError().entity(
                    new ErroValidacao(ex.getMessage())).build();
        
        }
        
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        //localhost:8080/pet-dogui/servico/5
        try {
        
            ServicoService service = new ServicoService();
            service.delete(id);
            
            return Response.ok().build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                    new ErroValidacao(ex.getMessage())).build();
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response findById(@PathParam("id") int id) {
        
        try {
            
            ServicoService service = new ServicoService();
            return Response.ok(service.findById(id)).build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            
            ServicoService service = new ServicoService();
            return Response.ok(service.findByAll()).build();

        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
        
    }
    
    @GET
    @Path("filter")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllWithParameters(@QueryParam("descricao") String descricao) {
        
        try {
            
            ServicoService service = new ServicoService();
            return Response.ok(service.findWithParameteres(descricao)).build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
    }
}
