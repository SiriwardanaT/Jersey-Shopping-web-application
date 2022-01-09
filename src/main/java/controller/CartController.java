package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constants.Constant;
import constants.cartConstants;
import modal.Cart;
import util.DatabaseConnection;

public class CartController {
	
	//Add items to cart
	public static Cart addToCart(Cart cart) throws SQLException, ClassNotFoundException {
		  String query =cartConstants.ADDTOCART;
		  Connection connection = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		  preparedStatement.setInt(Constant.INDEX_ONE, cart.getProductId());
		  preparedStatement.setString(Constant.INDEX_TWO, cart.getProductName());
		  preparedStatement.setInt(Constant.INDEX_TREE,cart.getUserId());
		  preparedStatement.setInt(Constant.INDEX_FOUR,cart.getQty());
		  preparedStatement.setDouble(Constant.INDEX_FIVE,cart.getPrice());
		
		  boolean successfullyAdded = preparedStatement.execute();
		  if(!successfullyAdded) {
			  return cart;
		  }
		  else {
			  return null;
		  }
	}
	
	//Get Total price for a particular product
	
	public static double CalTotalpriceForAProduct(int productId)throws ClassNotFoundException, SQLException {
		
		  double productTotalPrice = 0;
		  double totalPrice = 0;
		  
		  String calTotalQuey = cartConstants.GETTOTALPRICE;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(calTotalQuey);
		  preparedStatement.setInt(1,productId);
		  ResultSet rs = preparedStatement.executeQuery();
		  
		  while(rs.next()) {
				
			   productTotalPrice= rs.getDouble(1);
				totalPrice = productTotalPrice + totalPrice;
			}
		  
		return totalPrice;
		
		
		
		
	}
	
	//Get Total price for all products
	
	
	
	
	//Display cart details
	//half complete
	
	public static Cart getCartDetails(int userId) throws ClassNotFoundException, SQLException {
		
		String displayQuery = cartConstants.SHOWCART;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(displayQuery);
		preparedStatement.setInt(1,userId);
		ResultSet rs = preparedStatement.executeQuery();
		
		
		while(rs.next()) {
			
			String productName = rs.getString("productName");
			int qty = rs.getInt("qty");
			
			
		}
		return null;
		
		
	}
	

}
