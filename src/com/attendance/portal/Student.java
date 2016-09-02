package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Student {

	public static int addStudent(DataSource db, int rollno, String lastName, String firstName, String fathersName, int year, String branch, String phone) throws SQLException{
		Connection conn = db.getConnection();
		String s = "INSERT INTO Student VALUES(?,?,?,?,?,?,?)";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, rollno);
		p.setString(2,lastName);
		p.setString(3,firstName);
		p.setString(4,fathersName);
		p.setInt(5, year);
		p.setString(6,branch);
		p.setString(7, phone);
		return p.executeUpdate();
	}
	
	public static int deleteStudent(DataSource db, int rollno) throws SQLException{
		Connection conn = db.getConnection();
		String s = "DELETE FROM Student WHERE rollno = ? ";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, rollno);
		return p.executeUpdate();
	}
}
