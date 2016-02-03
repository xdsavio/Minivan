package servlets;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	
	public Connection getConnection() {
		
	     try {
	         return DriverManager.getConnection(
	        		 "jdbc:mysql://localhost:3306/van","root","");
	     } catch (SQLException e) {
	    	 System.out.println("Deu ruim");
	         throw new RuntimeException(e);
	     }
	 }
}