package com.attendance.portal;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;

import javax.sql.DataSource;

public class DBTestData {
	public static void setupTestData(DataSource db) throws SQLException, ParseException {
		Connection conn = db.getConnection();
		java.sql.Statement st = null;
		st = conn.createStatement();
		
		
		//Adding accounts to the login table
		st.executeUpdate("INSERT INTO Login "
				+ "VALUES('H13STU1','pass123','Student'),"
				+ "('H13STU2','pass123','Student'),"
				+ "('H13STU3','pass123','Student'),"
				+ "('H13STU4','pass123','Student'),"
				+ "('H13STU5','pass123','Student'),"
				+ "('H13STU6','pass123','Student'),"
				+ "('H13STU7','pass123','Student'),"
				+ "('H13STU8','pass123','Student'),"
				+ "('H13STU9','pass123','Student'),"
				+ "('F10FAC1','pass123','Faculty'),"
				+ "('F10FAC2','pass123','Faculty'),"
				+ "('F10FAC3','pass123','Faculty'),"
				+ "('F10FAC4','pass123','Faculty'),"
				+ "('F10FAC5','pass123','Faculty'),"
				+ "('F10FAC6','pass123','Faculty'),"
				+ "('Admin','pass123','Admin')");
		
		st.executeUpdate("INSERT INTO Student "
				+ "VALUES('H13STU1','Sundar','Ram','Pitahma','2013','CSE','9884345231'),"
				+ "('H13STU2','Guddanti','Vijay', 'Suresh Kumar', '2013', 'CSE', '9884348931'),"
				+ "('H13STU3','Kumari','Lavanaya', 'Ramesh Pendakur', '2013', 'CSE', '9885275322'),"
				+ "('H13STU4','Thapidi','Yamini', 'Bhargava Rao', '2013', 'CSE', '9883564233'),"
				+ "('H13STU5','Pasumarthy','Pradeep', 'Yadav Reddy', '2013', 'CSE', '87764736363'),"
				+ "('H13STU6','Peesarla','Bharath', 'Yogendar Rao', '2013', 'CSE', '8773462639'),"
				+ "('H13STU7','Kartlara','Pooja', 'Srinivas Reddy', '2013', 'CSE', '9846387463'),"
				+ "('H13STU8','Ravalla','Akhila', 'Babu Teja', '2013', 'CSE', '8712077823'),"
				+ "('H13STU9','Nimmala','Joseph', 'David', '2013', 'CSE', '9747018640')");
		
		st.executeUpdate("INSERT INTO Faculty "
				+ "VALUES('F10FAC1', 'Dawkins', 'Richard','9843746395'),"
				+ "('F10FAC2','Reddy', 'Bhaskar','8734708734'),"
				+ "('F10FAC3','Venkata','Madhu','9847593837'),"
				+ "('F10FAC4','V','Abhishek','9847593237'),"
				+ "('F10FAC5','Kumari','Aarthi','9843493837'),"
				+ "('F10FAC6','Kanthan','Kiran','8779835732')");
		
		st.executeUpdate("INSERT INTO Course "
				+ "VALUES('CSE101', 'Introduction to Programming'),"
				+ "('CSE102','Theory of Computing'),"
				+ "('CSE103','Java'),"
				+ "('CSE104','Databases'),"
				+ "('CSE105','HTML5 and WEB'),"
				+ "('CSE106','Compilers')");
		
		st.executeUpdate("INSERT INTO Course_Faculty "
				+ "VALUES('CSE101', 'F10FAC1'),"
				+ "('CSE102','F10FAC2'),"
				+ "('CSE103','F10FAC3'),"
				+ "('CSE104','F10FAC4'),"
				+ "('CSE105','F10FAC5'),"
				+ "('CSE106','F10FAC6')");
		
		st.executeUpdate("INSERT INTO Course_Student "
				+ "VALUES('CSE101', 'H13STU1'),"
				+ "('CSE101','H13STU2'),"
				+ "('CSE101','H13STU3'),"
				+ "('CSE101','H13STU4'),"
				+ "('CSE101','H13STU5'),"
				+ "('CSE101','H13STU6'),"
				+ "('CSE101','H13STU7'),"
				+ "('CSE101','H13STU8'),"
				+ "('CSE101','H13STU9'),"
				+ "('CSE102','H13STU1'),"
				+ "('CSE102','H13STU2'),"
				+ "('CSE102','H13STU3'),"
				+ "('CSE102','H13STU4'),"
				+ "('CSE102','H13STU5'),"
				+ "('CSE102','H13STU6'),"
				+ "('CSE102','H13STU7'),"
				+ "('CSE102','H13STU8'),"
				+ "('CSE102','H13STU9'),"
				+ "('CSE103','H13STU1'),"
				+ "('CSE103','H13STU2'),"
				+ "('CSE103','H13STU3'),"
				+ "('CSE103','H13STU4'),"
				+ "('CSE103','H13STU5'),"
				+ "('CSE103','H13STU6'),"
				+ "('CSE103','H13STU7'),"
				+ "('CSE103','H13STU8'),"
				+ "('CSE103','H13STU9'),"
				+ "('CSE104','H13STU1'),"
				+ "('CSE104','H13STU2'),"
				+ "('CSE104','H13STU3'),"
				+ "('CSE104','H13STU4'),"
				+ "('CSE104','H13STU5'),"
				+ "('CSE104','H13STU6'),"
				+ "('CSE104','H13STU7'),"
				+ "('CSE104','H13STU8'),"
				+ "('CSE104','H13STU9'),"
				+ "('CSE105','H13STU1'),"
				+ "('CSE105','H13STU2'),"
				+ "('CSE105','H13STU3'),"
				+ "('CSE105','H13STU4'),"
				+ "('CSE105','H13STU5'),"
				+ "('CSE105','H13STU6'),"
				+ "('CSE105','H13STU7'),"
				+ "('CSE105','H13STU8'),"
				+ "('CSE105','H13STU9'),"
				+ "('CSE106','H13STU1'),"
				+ "('CSE106','H13STU2'),"
				+ "('CSE106','H13STU3'),"
				+ "('CSE106','H13STU4'),"
				+ "('CSE106','H13STU5'),"
				+ "('CSE106','H13STU6'),"
				+ "('CSE106','H13STU7'),"
				+ "('CSE106','H13STU8'),"
				+ "('CSE106','H13STU9')");
		
		LinkedList<String> absentees = new LinkedList<>();
		absentees.add("H13STU1");
		EnterAttendance.enterAttendance(db, "CSE101", "2016-05-10", new LinkedList<String>());
		EnterAttendance.enterAttendance(db, "CSE101", "2016-05-14", absentees);
		absentees.clear();
		absentees.add("H13STU3");
		EnterAttendance.enterAttendance(db, "CSE101", "2016-05-19", absentees);
		EnterAttendance.enterAttendance(db, "CSE101", "2016-05-23", new LinkedList<String>());
		
		absentees.clear();
		absentees.add("H13STU2");
		EnterAttendance.enterAttendance(db, "CSE102", "2016-05-10", new LinkedList<String>());
		EnterAttendance.enterAttendance(db, "CSE102", "2016-05-14", absentees);
		absentees.clear();
		absentees.add("H13STU4");
		absentees.add("H13STU6");
		EnterAttendance.enterAttendance(db, "CSE102", "2016-05-19", absentees);
		EnterAttendance.enterAttendance(db, "CSE102", "2016-05-23", new LinkedList<String>());
		
		absentees.clear();
		absentees.add("H13STU7");
		EnterAttendance.enterAttendance(db, "CSE103", "2016-05-10", new LinkedList<String>());
		EnterAttendance.enterAttendance(db, "CSE103", "2016-05-14", absentees);
		absentees.clear();
		absentees.add("H13STU7");
		absentees.add("H13STU9");
		EnterAttendance.enterAttendance(db, "CSE103", "2016-05-19", absentees);
		EnterAttendance.enterAttendance(db, "CSE103", "2016-05-23", new LinkedList<String>());
		
		absentees.clear();
		absentees.add("H13STU1");
		EnterAttendance.enterAttendance(db, "CSE104", "2016-05-10", new LinkedList<String>());
		EnterAttendance.enterAttendance(db, "CSE104", "2016-05-14", absentees);
		absentees.clear();
		absentees.add("H13STU4");
		absentees.add("H13STU6");
		EnterAttendance.enterAttendance(db, "CSE104", "2016-05-19", absentees);
		EnterAttendance.enterAttendance(db, "CSE104", "2016-05-23", new LinkedList<String>());
		
		absentees.clear();
		absentees.add("H13STU6");
		EnterAttendance.enterAttendance(db, "CSE105", "2016-05-10", new LinkedList<String>());
		EnterAttendance.enterAttendance(db, "CSE105", "2016-05-14", absentees);
		absentees.clear();
		absentees.add("H13STU4");
		absentees.add("H13STU7");
		EnterAttendance.enterAttendance(db, "CSE105", "2016-05-19", absentees);
		EnterAttendance.enterAttendance(db, "CSE105", "2016-05-23", new LinkedList<String>());
		
		absentees.clear();
		absentees.add("H13STU2");
		absentees.add("H13STU9");
		EnterAttendance.enterAttendance(db, "CSE106", "2016-05-10", new LinkedList<String>());
		EnterAttendance.enterAttendance(db, "CSE106", "2016-05-14", absentees);
		absentees.clear();
		absentees.add("H13STU5");
		absentees.add("H13STU6");
		EnterAttendance.enterAttendance(db, "CSE106", "2016-05-19", absentees);
		EnterAttendance.enterAttendance(db, "CSE106", "2016-05-23", new LinkedList<String>());
		
		st.close();
		conn.commit();
		conn.close();
	}
}
