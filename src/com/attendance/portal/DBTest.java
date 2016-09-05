package com.attendance.portal;


import java.sql.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.hsqldb.Statement;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class DBTest {
	public static void main(String[] args) throws SQLException, ParseException{
		DataSource db = dataSource();
		createTable(db);
		Connection conn = db.getConnection();
		java.sql.Statement st = null;
		st = conn.createStatement();        
		st.executeUpdate("INSERT INTO Student VALUES ('1','Doma','Anurag','SRD',4,'CSE',8178969617) "); 
		st.executeUpdate("INSERT INTO Student VALUES ('2','Toma','Aditya','SRD',4,'CSE',8178969617) "); 
		st.executeUpdate("INSERT INTO Student VALUES ('3','Poma','Akhil','RV',4,'CSE',8178969617) "); 
		st.executeUpdate("INSERT INTO Student VALUES ('4','Goma','Abhishek','MV',4,'CSE',8178969617) "); 
		
		/*st.executeUpdate("INSERT INTO Course_Student VALUES (1,'1') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (1,'2') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (1,'3') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (1,'4') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (1,'5') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (1,'6') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (2,'1') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (2,'2') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (2,'3') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (2,'4') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (2,'5') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (2,'6') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (3,'1') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (3,'2') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (3,'3') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (3,'4') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (3,'5') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (3,'6') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (4,'1') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (4,'2') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (4,'3') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (4,'4') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (4,'5') "); 
		st.executeUpdate("INSERT INTO Course_Student VALUES (4,'6') "); */
		
		LinkedList<String> absentees = new LinkedList<String>();
		
		//absentees.add("3");
		//absentees.add("4");
		LinkedList<String> absentee = new LinkedList<String>();
		absentee.add("1");
		System.out.println(EnterAttendance.enterAttendance(db, 1, "2016-09-04", absentee));
		System.out.println(EnterAttendance.enterAttendance(db, 2, "2016-09-04", absentees));
		System.out.println(EnterAttendance.enterAttendance(db, 3, "2016-09-04", absentees));
		System.out.println(EnterAttendance.enterAttendance(db, 4, "2016-09-04", absentees));
		System.out.println(EnterAttendance.enterAttendance(db, 5, "2016-09-04", absentees));
		System.out.println(EnterAttendance.enterAttendance(db, 6, "2016-09-04", absentees));
		//System.out.println(EnterAttendance.enterAttendance(db, 1, "2016-09-05", absentees));
		//ResultSet rs = st.executeQuery("SELECT * FROM Attendance");
		//ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Attendance WHERE StudentId = '1' AND CourseId = '1' AND Status = 'Present'");
		//ResultSet rs = st.executeQuery("SELECT * FROM Login");
		//ResultSet rs = st.executeQuery("SELECT Id FROM Login");
		//dump(rs); 
		//System.out.println();
		//System.out.println(dumpToList(rs));
		//st.executeUpdate("INSERT INTO Faculty VALUES(2,'dell','inspiron','12345')");
		//System.out.println(Course.addCourse(db, 1,"Java"));
		//System.out.println(Course.deleteCourse(db, 1));
		/*System.out.println(Faculty.addFaculty(db, "1", "a", "b", "123", "qwerty"));
		System.out.println(Faculty.deleteFaculty(db, "1"));
		System.out.println(Student.addStudent(db, "5", "lastName", "firstName", "fathersName", 4, "branch", "phone", "password"));
		System.out.println(Student.deleteStudent(db, "5"));*/
		Attendance at = ViewAttendance.viewAttendance(db, "1");
		System.out.println(at.percentage);
		System.out.println(at.totalClasses);
		System.out.println(at.totalPresent);
		System.out.println(at.name);
		System.out.println(at.sub1+at.Sub1Total+at.Sub1Present);
		//System.out.println();
		//Faculty.viewFaculty(db,1);
		//Student.viewStudent(db);
		//Student.viewStudent(db,1);
		st.close();
		conn.commit();
		conn.close();
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
	
	public static LinkedList<String> dumpToList(ResultSet rs) throws SQLException{
		ResultSetMetaData meta   = rs.getMetaData();
        int colmax = meta.getColumnCount();
        int i;
        Object o = null;
        LinkedList<String> ll = new LinkedList<String>();
        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);    // Is SQL the first column is indexed
                // with 1 not 0
                //System.out.print(o.toString() + " ");
                ll.add(o.toString());
            }
            //System.out.println(" ");
        }
		return ll;
	}
}
