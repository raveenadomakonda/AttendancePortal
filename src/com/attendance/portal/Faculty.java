package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Faculty {
	public static int addFaculty(DataSource db, int facultyId, String lastName, String firstName, String phone) throws SQLException{
		Connection conn = db.getConnection();
		String s = "INSERT INTO Faculty VALUES(?,?,?,?)";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, facultyId);
		p.setString(2,lastName);
		p.setString(3,firstName);
		p.setString(4, phone);
		int i = p.executeUpdate();
		conn.commit();
		conn.close();
		return i;
	}
	public static int deleteFaculty(DataSource db, int facultyId) throws SQLException{
		Connection conn = db.getConnection();
		String s = "DELETE FROM Faculty WHERE FacultyId = ? ";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, facultyId);
		int i = p.executeUpdate();
		conn.commit();
		conn.close();
		return i;
	}
}
