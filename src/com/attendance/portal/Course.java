package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Course {
	public static int addCourse(DataSource db, int courseId, String courseName) throws SQLException{
		Connection conn = db.getConnection();
		String s = "INSERT INTO Course VALUES(?,?)";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, courseId);
		p.setString(2,courseName);
		int i = p.executeUpdate();
		conn.commit();
		conn.close();
		return i;
	}
	
	public static int deleteCourse(DataSource db, int courseId) throws SQLException{
		Connection conn = db.getConnection();
		String s = "DELETE FROM Course WHERE CourseId = ? ";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(1, courseId);
		int i = p.executeUpdate();
		conn.commit();
		conn.close();
		return i;
	}

}
