package routers;


import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;import javax.ws.rs.core.Response.Status;

import controller.ProductController;
import modal.Product;


@Path("product")
public class ProductRouter {
	//http://localhost:8080/test5/rest/product :GET
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllProduct() throws ClassNotFoundException, SQLException{
    	
    	if(ProductController.getProducts().isEmpty()) {
    		return Response.status(Status.NOT_FOUND).entity("No Products founds").build();
    	}
    	else {
    		return Response.status(Status.ACCEPTED).entity(ProductController.getProducts()).build();
    	}
    	
	}
    
    
    //http://localhost:8080/test5/rest/product :POST
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) throws ClassNotFoundException, SQLException {
    	 System.out.println(product);
    	 Product Createdproduct = ProductController.createProduct(product);
    	 if(Createdproduct != null) {
    		 return Response.status(Status.CREATED).entity(Createdproduct).build();
    	 }
    	 else {
    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
    	 }
    	 
    }
    
    //http://localhost:8080/test5/rest/product :PUT
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response DeleteAllProduct(@PathParam("id") String id){
    	
    	return Response.status(Status.OK).entity(id).build();
    
    	
	}
    
   
  
    	
    
  
 }
    
    


