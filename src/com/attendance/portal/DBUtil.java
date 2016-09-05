package com.attendance.portal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

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
	
	public static void createTable(DataSource db) throws SQLException {
		Connection conn = db.getConnection();
		java.sql.Statement st = null;
		st = conn.createStatement();
		st.executeUpdate("CREATE TABLE Student ("
				+ "Rollno varchar(255),"
				+ "LastName varchar(255),"
				+ "FirstName varchar(255),"
				+ "FatherName varchar(255),"
				+ "Year int,"
				+ "Branch varchar(255),"
				+ "Phone varchar(255))");
		//System.out.println("Student table created");
		st.executeUpdate("CREATE TABLE Faculty ("
				+ "FacultyId varchar(255),"
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
		st.executeUpdate("INSERT INTO Login VALUES('Anurag','anu123','Admin'),('Raveena','rav123','Student'),('Sunny','sun123','Faculty')");
		//System.out.println("Login Table created");
		st.executeUpdate("CREATE TABLE Course_Faculty("
				+ "CourseId int, "
				+ "FacultyId varchar(255))");
		st.executeUpdate("CREATE TABLE Course_Student("
				+ "CourseId int, "
				+ "StudentId varchar(255))");
		st.executeUpdate("CREATE TABLE Attendance("
				+ "StudentId varchar(255), "
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
	
	public static LinkedList<String> dumpToList(ResultSet rs) throws SQLException{
		ResultSetMetaData meta   = rs.getMetaData();
        int colmax = meta.getColumnCount();
        int i;
        Object o = null;
        LinkedList<String> ll = new LinkedList<String>();
        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);    
                ll.add(o.toString());
            }
        }
		return ll;
	}
	
	public static java.sql.Date sqlDate(String date) throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date javaDate = sdf1.parse(date);
		return new java.sql.Date(javaDate.getTime()); 
	}
}
