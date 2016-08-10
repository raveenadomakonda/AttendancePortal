package com.usbrazilworkshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.util.SystemPropertyUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.usbrazilworkshop.ResultSetParser;

public class DBDao {
	
	private Connection conn;
	private String jdbcUrl;
	
	public DBDao(){
		String hostname = "cybersecuritydb.cmvtsvmxktce.us-west-2.rds.amazonaws.com:3306";
		jdbcUrl = "jdbc:mysql://" + hostname + "/" + "profiledb" + "?user=" + "usbrazilworkshop" + "&password=" + "Quickweb1!";
		try {
		    System.out.println("Loading driver...");
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} 
		catch (ClassNotFoundException e) {
		    throw new RuntimeException("Cannot find the driver in the classpath!", e);
		}
	}
	
	public List<Profile> getProfiles(String location) {

		try {
			System.out.println("Connecting...");
		    conn = DriverManager.getConnection(jdbcUrl);
		    System.out.println("Connected...");
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Profile Where Location=\""+location+"\";");
			return ResultSetParser.parseProfiles(resultSet);
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			System.out.println("Closing the connection.");
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ignore) {}
		}		    
			    
		return null;
	}
	
	public boolean addProfile(String data,String location) throws Exception{
		System.out.println("Adding profile");
		JsonElement jelement = new JsonParser().parse(data);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    String name = jobject.get("name").getAsString();
		String position = jobject.get("position").getAsString();
		String organization = jobject.get("organization").getAsString();
		String email = jobject.get("email").getAsString();
		String researchArea = jobject.get("researchArea").getAsString();
		String bio = jobject.get("bio").getAsString();
		String photoUrl = jobject.get("photoUrl").getAsString();
		String code = jobject.get("code").getAsString();
		
		boolean retval = true;
		if(isValid(code) == false){
			System.out.println("Code doesnt match!");
			return false;
		}
			
			
	
		try {
			System.out.println("Connecting...");
		    conn = DriverManager.getConnection(jdbcUrl);
		    System.out.println("Connected...");
			/*
		    Statement statement = conn.createStatement();
			String query = getQuery(name, position, organization, email, researchArea, bio, photoUrl,location);
			int resultSet = statement.executeUpdate(query);
			*/
		    
		    //Updated to use prepared statement
		    String query = "Insert into Profile(Name, Position,Organization,Email,ResearchArea,Bio,PhotoUrl,Location) values(?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement= conn.prepareStatement(query);
			statement.setString(1,name);
			statement.setString(2,position);
			statement.setString(3,organization);
			statement.setString(4,email);
			statement.setString(5,researchArea);
			statement.setString(6,bio);
			statement.setString(7,photoUrl);
			statement.setString(8,location);
			
			int resultSet = statement.executeUpdate();
			
			
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			retval = false;
		} finally {
			System.out.println("Closing the connection.");
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ignore) {}
		}
		return retval;
	}
	
	// deprecated after using prepared statement
	private String getQuery(String name, String position, String organization, String email, String researchArea,
			String bio, String photoUrl, String location) {
		
		String query = "Insert into Profile(Name, Position,Organization,Email,ResearchArea,Bio,PhotoUrl,Location) values(\""+name+"\", \""+position+"\", \""+organization+"\", \""+email+"\", \""+researchArea+"\", \""+bio+"\", \""+photoUrl+"\", \""+location+"\");";
		System.out.println(query);
		return query;
	}
	
	private boolean isValid(String code){
		String securityCode = "usbcsw2015bioreg";
		System.out.println("Code: "+code);
		return securityCode.equals(code);
	}
	
}
