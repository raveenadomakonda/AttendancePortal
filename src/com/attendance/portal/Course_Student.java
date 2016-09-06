package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;



public class Course_Student {
	public static boolean addCourse_Student(DataSource db,LinkedList<String> courses, String rollno) throws SQLException{
		Connection conn = db.getConnection();
		String sz = "INSERT INTO Course_Student VALUES(?,?)";
		PreparedStatement z = conn.prepareStatement(sz);
		z.setString(2, rollno);
		for(String sc :courses){
			z.setString(1, sc);
			int k = z.executeUpdate();
			if(k == 0){
				System.out.println("Could not insert Student's course into Course_Student table");
				return false;
			}
		}	
			conn.commit();
			conn.close();	
		return true;
	}

}
