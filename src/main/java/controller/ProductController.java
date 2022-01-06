package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import constants.Constant;
import constants.productConstant;
import modal.Product;
import util.DatabaseConnection;

//product controller

public class ProductController {
	//get all
	public static ArrayList<Product> getProducts() throws ClassNotFoundException, SQLException {
		ArrayList<Product> plist = new ArrayList<>();
		String getQury = productConstant.GETALLPRODUCT;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Product product = new Product();
			product.setPname(rs.getString(Constant.INDEX_ONE));
			product.setPrice(rs.getDouble(Constant.INDEX_TWO));
			product.setAqun(rs.getInt(Constant.INDEX_TREE));
			
			plist.add(product);
		}
		return  plist;
		
	}
	//create
	public static Product createProduct(Product product) throws SQLException, ClassNotFoundException {
		  String CreateQury =productConstant.CREATEPRODUCT;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setString(Constant.INDEX_ONE, product.getPname());
		  preparedStatement.setDouble(Constant.INDEX_TWO, product.getPrice());
		  preparedStatement.setInt(Constant.INDEX_TREE, product.getAqun());
		  
		  boolean isCreate = preparedStatement.execute();
		  if(!isCreate) {
			  return product;
		  }
		  else {
			  return null;
		  }
	}
	 public static void main(String [] args) {
	    	 try {
				System.out.println(getProducts());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
}
