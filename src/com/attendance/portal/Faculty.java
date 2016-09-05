package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Faculty {
	public static boolean addFaculty(DataSource db, String facultyId, String lastName, String firstName, String phone,String password) throws SQLException{
		Connection conn = db.getConnection();
		String s = "INSERT INTO Faculty VALUES(?,?,?,?)";
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1, facultyId);
		p.setString(2,lastName);
		p.setString(3,firstName);
		p.setString(4, phone);
		int i = p.executeUpdate();
		if(i == 0){
			System.out.println("Could not insert into Faculty table");
			return false;
		}
		String s1 = "INSERT INTO Login VALUES (?,?,'Faculty')";
		PreparedStatement q = conn.prepareStatement(s1);
		q.setString(1, facultyId);
		q.setString(2,password);
		int j = q.executeUpdate();
		if(j == 0){
			System.out.println("Could not insert Facluty info into Login table");
			return false;
		}
		conn.commit();
		conn.close();
		return true;
	}
	public static boolean deleteFaculty(DataSource db, String facultyId) throws SQLException{
		Connection conn = db.getConnection();
		String s = "DELETE FROM Faculty WHERE FacultyId = ? ";
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1, facultyId);
		int i = p.executeUpdate();
		if(i == 0){
			System.out.println("Could not delete from Faculty table");
			return false;
		}
		String s1 = "DELETE FROM Login WHERE Id = ?";
		PreparedStatement q = conn.prepareStatement(s1);
		q.setString(1, facultyId);
		int j = q.executeUpdate();
		if(j == 0){
			System.out.println("Could not delete Facluty info from Login table");
			return false;
		}
		conn.commit();
		conn.close();
		return true;
	}
	
	public static void viewFaculty(DataSource db) throws SQLException{
		Connection conn = db.getConnection();
		java.sql.Statement st = null;
		st = conn.createStatement();        
		ResultSet rs = st.executeQuery("SELECT * FROM Faculty"); 
		DBUtil.dump(rs);
		st.close();
		conn.commit();
		conn.close();
		
	}
	
	public static void viewFaculty(DataSource db, String facultyId) throws SQLException{
		Connection conn = db.getConnection();
		String s = "SELECT * FROM Faculty WHERE FacultyId = ?";   
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1, facultyId);
		ResultSet rs = p.executeQuery();
		DBUtil.dump(rs);
		conn.commit();
		conn.close();
		
	}
	
}
