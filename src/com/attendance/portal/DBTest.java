package com.attendance.portal;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.*;

import javax.sql.DataSource;

import org.hsqldb.Statement;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class DBTest {
	public static void main(String[] args) throws SQLException{
		DataSource db = dataSource();
		createTable(db);
		Connection conn = db.getConnection();
		java.sql.Statement st = null;
		st = conn.createStatement();        
		st.executeUpdate("INSERT INTO Student VALUES (1,'Doma','Anurag','SRD',4,'CSE',8178969617) "); 
		ResultSet rs = st.executeQuery("SELECT * FROM Student");
		dump(rs); 
		st.close();
		conn.commit();
		conn.close();
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

	public static DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
			//.addScript("C:\\Users\\Anurag\\git\\AttendancePortal\\db\\sql\\CreateTable.sql") //Add these later when you have your schema figured out raveena
			//.addScript("db/sql/insert-data.sql")
			.build();
		System.out.println("DB Bean Created !!! ");
		return db;
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
