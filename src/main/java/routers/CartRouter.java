package routers;

import java.sql.SQLException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import controller.CartController;

import modal.Cart;


@Path("cart")
public class CartRouter {
	
	
	    @POST
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response addItemToCart(Cart cart) throws ClassNotFoundException, SQLException {
	    	 System.out.println(cart);
	    	 Cart addedItemTocart = CartController.addToCart(cart);
	    	 if(addedItemTocart != null) {
	    		 return Response.status(Status.CREATED).entity(addedItemTocart).build();
	    	 }
	    	 else {
	    		 return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
	    	 }
	    	 
	    }
}
