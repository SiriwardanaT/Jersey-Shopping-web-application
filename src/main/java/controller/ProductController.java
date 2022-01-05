package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modal.Product;
import util.DatabaseConnection;

//product controller
public class ProductController {
	
	public static ArrayList<Product> getProducts() throws ClassNotFoundException, SQLException {
		ArrayList<Product> plist = new ArrayList<>();
		String getQury = "select 'pname','price','Aqun' from product";
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Product product = new Product();
			product.setPname(rs.getString(1));
			product.setPrice(rs.getDouble(2));
			product.setAqun(rs.getInt(3));
			
			plist.add(product);
		}
		return  plist;
		
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
