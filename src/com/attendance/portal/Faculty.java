package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Faculty {
	public static void addFaculty(DataSource db, int facultyId, String lastName, String firstName, String phone,String password) throws SQLException{
		Connection conn = db.getConnection();
		String s = "INSERT INTO Faculty VALUES(?,?,?,?)";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, facultyId);
		p.setString(2,lastName);
		p.setString(3,firstName);
		p.setString(4, phone);
		int i = p.executeUpdate();
		if(i == 0){
			System.out.println("Could not insert into Faculty table");
		}
		String s1 = "INSERT INTO Login VALUES (?,?,'Faculty')";
		PreparedStatement q = conn.prepareStatement(s1);
		q.setInt(1, facultyId);
		q.setString(2,password);
		int j = q.executeUpdate();
		if(j == 0){
			System.out.println("Could not insert Facluty info into Login table");
		}
		conn.commit();
		conn.close();
	}
	public static void deleteFaculty(DataSource db, int facultyId) throws SQLException{
		Connection conn = db.getConnection();
		String s = "DELETE FROM Faculty WHERE FacultyId = ? ";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, facultyId);
		int i = p.executeUpdate();
		if(i == 0){
			System.out.println("Could not delete Faculty table");
		}
		String s1 = "DELETE FROM Login WHERE Id = ?";
		PreparedStatement q = conn.prepareStatement(s1);
		q.setInt(1, facultyId);
		int j = q.executeUpdate();
		if(j == 0){
			System.out.println("Could not delete Facluty info from Login table");
		}
		conn.commit();
		conn.close();
		
	}
	//public static int viewFaculty(DataSource db, int facultyId){
		
	//}
}
