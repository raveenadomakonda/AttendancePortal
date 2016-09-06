package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;

public class Student {

	public static boolean addStudent(DataSource db, String rollno, String lastName, String firstName, String fathersName, int year, String branch, String phone, String password, LinkedList<String> courses) throws SQLException{
		Connection conn = db.getConnection();
		String s = "INSERT INTO Student VALUES(?,?,?,?,?,?,?)";
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1, rollno);
		p.setString(2,lastName);
		p.setString(3,firstName);
		p.setString(4,fathersName);
		p.setInt(5, year);
		p.setString(6,branch);
		p.setString(7, phone);
		int i = p.executeUpdate();
		if(i == 0){
			System.out.println("Could not insert into Student table");
			return false;
		}
		String s1 = "INSERT INTO Login VALUES (?,?,'Student')";
		PreparedStatement q = conn.prepareStatement(s1);
		q.setString(1, rollno);
		q.setString(2,password);
		int j = q.executeUpdate();
		if(j == 0){
			System.out.println("Could not insert Student info into Login table");
			return false;
		}
		
		// This part of code is not tested
		/*String sz = "INSERT INTO Course_Student VALUES(?,?)";
		PreparedStatement z = conn.prepareStatement(sz);
		z.setString(2, rollno);
		for(String sc :courses){
			z.setString(1, sc);
			int k = z.executeUpdate();
			if(k == 0){
				System.out.println("Could not insert Student's course into Course_Student table");
				return false;
			}
			
		}*/
		
		conn.commit();
		conn.close();
		return true;
	}
	
	public static boolean deleteStudent(DataSource db, String rollno) throws SQLException{
		Connection conn = db.getConnection();
		String s = "DELETE FROM Student WHERE Rollno = ? ";
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1, rollno);
		int i = p.executeUpdate();
		if(i == 0){
			System.out.println("Could not delete from Student table");
			return false;
		}
		String s1 = "DELETE FROM Login WHERE Id = ?";
		PreparedStatement q = conn.prepareStatement(s1);
		q.setString(1, rollno);
		int j = q.executeUpdate();
		if(j == 0){
			System.out.println("Could not delete Student info from Login table");
			return false;
		}
		conn.commit();
		conn.close();
		return true;
	}
	
	public static void viewStudent(DataSource db) throws SQLException{
		Connection conn = db.getConnection();
		java.sql.Statement st = null;
		st = conn.createStatement();        
		ResultSet rs = st.executeQuery("SELECT * FROM Student"); 
		DBUtil.dump(rs);
		st.close();
		conn.commit();
		conn.close();
		
	}
	
	public static void viewStudent(DataSource db, String rollno) throws SQLException{
		Connection conn = db.getConnection();
		String s = "SELECT * FROM Student WHERE Rollno = ?";   
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1, rollno);
		ResultSet rs = p.executeQuery();
		DBUtil.dump(rs);
		conn.commit();
		conn.close();
		
	}
	
}
