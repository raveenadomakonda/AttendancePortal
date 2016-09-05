package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParseException;
import java.util.LinkedList;


import javax.sql.DataSource;

public class EnterAttendance {
	public static boolean enterAttendance(DataSource db,int courseId, String date, LinkedList<String> absentees) throws SQLException, ParseException{ 
		Connection conn = db.getConnection();
		LinkedList<Integer> integerAbsentees = new LinkedList<Integer>();
		java.sql.Statement st = null;
		st = conn.createStatement();        
		ResultSet rs = st.executeQuery("SELECT DISTINCT Rollno FROM Student"); 
		LinkedList<String> list = DBUtil.dumpToList(rs);
		System.out.println(list);
		st.close();
		String s = "INSERT INTO Attendance VALUES(?,?,?,?)";
		PreparedStatement p = conn.prepareStatement(s);
		p.setInt(2, courseId);
		p.setDate(3, DBUtil.sqlDate(date));
		//while(!absentees.isEmpty()){
			//integerAbsentees.add(Integer.valueOf(absentees.remove()));
		//}	
		list.removeAll(absentees);
		while(!list.isEmpty()){
			int rollno = Integer.parseInt(list.remove());
			p.setInt(1, rollno);
			p.setString(4, "Present");
			int i = p.executeUpdate();
			if(i == 0){
				System.out.println("Could not insert into Attendance table for present Student"+" - "+rollno);
				return false;
			}
		}
		while(!absentees.isEmpty()){
			int rollno = Integer.parseInt(absentees.remove());
			p.setInt(1, rollno);
			p.setString(4, "Absent");
			int j = p.executeUpdate();
			if(j == 0){
				System.out.println("Could not insert into Attendance table for absent Student"+" - "+rollno);
				return false;
			}
		}
		conn.commit();
		conn.close();
		
		return true;
	}
	
	

}
