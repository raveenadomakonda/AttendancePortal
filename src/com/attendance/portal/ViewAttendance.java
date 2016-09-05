package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;

public class ViewAttendance {
	public static Attendance viewAttendance(DataSource db, String rollno) throws SQLException{
		
		Connection conn = db.getConnection();
		String s = "SELECT DISTINCT CourseId FROM Attendance WHERE StudentId = ? ";
		String total  = "SELECT COUNT(*) AS C FROM Attendance WHERE StudentId = ? AND CourseId = ?";
		String totalPresent = "SELECT COUNT(*) FROM Attendance WHERE StudentId = ? AND CourseId = ? AND Status = 'Present'";
		String name = "SELECT FirstName, LastName FROM Student WHERE Rollno = ?";
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1, rollno);
		ResultSet rs = p.executeQuery();
		LinkedList<String> courseList = DBUtil.dumpToList(rs);
		LinkedList<Integer> totalClasses = new LinkedList<Integer>();
		LinkedList<Integer> totalPresentClasses = new LinkedList<Integer>();
		LinkedList<Integer> totalAbsentClasses = new LinkedList<Integer>();
		PreparedStatement q = conn.prepareStatement(total);
		q.setString(1,rollno);
		System.out.println("courseList"+courseList);
		for(String course : courseList){
			q.setInt(2, Integer.valueOf(course));
			ResultSet res = q.executeQuery();
			totalClasses.add(DBUtil.getTotal(res));
		}

		PreparedStatement r = conn.prepareStatement(totalPresent);
		r.setString(1,rollno);
		for(String presentTotal : courseList){
			r.setInt(2, Integer.valueOf(presentTotal));
			ResultSet result = r.executeQuery();
			//DBUtil.dump(result);
			//System.out.println(result.getInt("C"));
			
			totalPresentClasses.add(DBUtil.getTotal(result));
			//System.out.println("totalpresent "+ totalPresentClasses);
		}
		
		//System.out.println("totalpresent "+ totalPresentClasses);
		if(totalPresentClasses.size() != totalClasses.size()){
			System.out.println(" totalClasses list and totalClassesPresent list are not same size ");
		}
		for(int i=0; i< totalPresentClasses.size(); i++){
			totalAbsentClasses.add(totalClasses.get(i) - totalPresentClasses.get(i));
		}
		PreparedStatement t = conn.prepareStatement(name);
		t.setString(1,rollno);
		ResultSet res12 = t.executeQuery();
		LinkedList<String> names = DBUtil.dumpToList(res12);
		String studentName = names.getFirst()+ names.getLast();
		String sub1 = courseList.get(0);
		String sub2 = courseList.get(1);
		String sub3 = courseList.get(2);
		String sub4 = courseList.get(3);
		String sub5 = courseList.get(4);
		String sub6 = courseList.get(5);
		int Sub1Total = totalClasses.get(0);
		int Sub1Present = totalPresentClasses.get(0);
		int Sub2Total = totalClasses.get(1);
		int Sub2Present = totalPresentClasses.get(1);
		int Sub3Total = totalClasses.get(2);
		int Sub3Present = totalPresentClasses.get(2);
		int Sub4Total =  totalClasses.get(3);
		int Sub4Present = totalPresentClasses.get(3);
		int Sub5Total = totalClasses.get(4);
		int Sub5Present = totalPresentClasses.get(4);
		int Sub6Total = totalClasses.get(5);
		int Sub6Present = totalPresentClasses.get(5);
		
		int totalPresentFC = 0;
		for(Integer i : totalPresentClasses){
			totalPresentFC = totalPresentFC + i;
		}
		int totalAbsentFC;
		int totalClassesFC = 0;
		for(Integer i : totalClasses){
			totalClassesFC = totalClassesFC + i;
		}
		float percentage = ((float)totalPresentFC/(float)totalClassesFC) * 100;
		Attendance a = new Attendance( totalPresentFC, totalClassesFC, sub1, sub2, sub3, sub4, sub5, sub6, Sub1Total,Sub1Present, Sub2Total,Sub2Present, Sub3Total, Sub3Present, Sub4Total, Sub4Present, Sub5Total, Sub5Present, Sub6Total, Sub6Present, studentName, percentage );
		System.out.println(" totalclasses"+totalClassesFC);
		System.out.println("totalpresent "+ totalPresentFC);
		//System.out.println("totalabsent"+totalAbsentClasses);
		conn.commit();
		conn.close();
		return a;
	}
}
