package com.attendance.portal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class DBUtil {

	public static DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
			.build();
		System.out.println("DB Bean Created !!! ");
		return db;
	}
	
	private static void createTable(DataSource db) throws SQLException {
		Connection conn = db.getConnection();
		java.sql.Statement st = null;
		st = conn.createStatement();
		st.executeUpdate("CREATE TABLE Student ("
				+ "Rollno int,"
				+ "LastName varchar(255),"
				+ "FirstName varchar(255),"
				+ "FatherName varchar(255),"
				+ "Year int,"
				+ "Branch varchar(255),"
				+ "Phone varchar(255))");
		//System.out.println("Student table created");
		st.executeUpdate("CREATE TABLE Faculty ("
				+ "FacultyId int,"
				+ "LastName varchar(255),"
				+ "FirstName varchar(255),"
				+ "Phone varchar(255))");
		//System.out.println("Faculty table created");
		st.executeUpdate("CREATE TABLE Course ("
				+"CourseId int,"
				+"CourseName varchar(255))");
		//System.out.println("Course Table Created");
		st.executeUpdate("CREATE TABLE Login ("
				+ "Id varchar(255), "
				+ "Password varchar(255), "
				+ "Type varchar(255))");
		st.executeUpdate("INSERT INTO Login VALUES('Anurag','anu123','Admin')");
		//System.out.println("Login Table created");
		st.executeUpdate("CREATE TABLE Course_Faculty("
				+ "CourseId int, "
				+ "FacultyId int)");
		st.executeUpdate("CREATE TABLE Course_Student("
				+ "CourseId int, "
				+ "StudentId int)");
		st.executeUpdate("CREATE TABLE Attendance("
				+ "StudentId int, "
				+ "CourseId int, "
				+ "Date date, "
				+ "Status varchar(255))");
		System.out.println("All tables created");
		st.close();
		conn.commit();
		conn.close();
		
	}

	public static void dump(ResultSet rs) throws SQLException {
        ResultSetMetaData meta   = rs.getMetaData();
        int colmax = meta.getColumnCount();
        int i;
        Object o = null;
        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);    // Is SQL the first column is indexed
                // with 1 not 0
                System.out.print(o.toString() + " ");
            }
            System.out.println(" ");
        }
    }      
}
