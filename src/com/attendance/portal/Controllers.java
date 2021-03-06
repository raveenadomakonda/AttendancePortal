package com.attendance.portal;

import java.util.Arrays;
import java.util.LinkedList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class Controllers {
	
	@Autowired Gson gson;
	@Autowired DataSource dataSource;
	@Autowired Login loginHandler;
	
	@RequestMapping(value = "/sampleRestApi", method = RequestMethod.GET)
	public @ResponseBody
	String exampleFunction() {
		String text = "Server says hi!";
		return gson.toJson(text);
	}
	
	@RequestMapping(value = "/loginDo", method = RequestMethod.GET)
	public @ResponseBody
	String login(
			@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password) {
		System.out.println(username + "	" + password);
		Validation result;
		try{
			result = loginHandler.validate(dataSource, username, password);
		} catch(Exception e) {
			e.printStackTrace();
			result = new Validation(false, "Error");
		}
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/addFacultyDo", method = RequestMethod.GET)
	public @ResponseBody
	String addFaculty(
			@RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "lastName", required = true) String lastName,
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "phoneNumber", required = true) String phoneNumber,
            @RequestParam(value = "password", required = true) String password) {
		System.out.println(firstName + "	" + lastName + "	" + id + "	" + phoneNumber + "	" + password);
		boolean result;
		try{
			result = Faculty.addFaculty(dataSource, id, lastName, firstName, phoneNumber, password);
			Faculty.viewFaculty(dataSource);
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/deleteFacultyDo", method = RequestMethod.GET)
	public @ResponseBody
	String deleteFaculty(
            @RequestParam(value = "id", required = true) String id) {
		System.out.println(id);
		boolean result;
		try{
			result = Faculty.deleteFaculty(dataSource, id);
			Faculty.viewFaculty(dataSource);
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/addStudentDo", method = RequestMethod.GET)
	public @ResponseBody
	String addStudent(
			@RequestParam(value = "firstName", required = true) String firstName,
            @RequestParam(value = "lastName", required = true) String lastName,
            @RequestParam(value = "fathersName", required = true) String fathersName,
            @RequestParam(value = "branch", required = true) String branch,
            @RequestParam(value = "year", required = true) String year,
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "phoneNumber", required = true) String phoneNumber,
            @RequestParam(value = "courses", required = true) String courses,
            @RequestParam(value = "password", required = true) String password) {
		System.out.println(firstName + "	" + lastName + "	" + id + "	" + phoneNumber + "	" + password);
		boolean result;
		try{
			result = Student.addStudent(dataSource, id, lastName, firstName, fathersName, Integer.parseInt(year), branch, phoneNumber, password);
			Student.viewStudent(dataSource);
			//Enroll student in courses
			LinkedList<String> courseList = (courses == null || courses.isEmpty()) ? new LinkedList<String>() : new LinkedList<String>(Arrays.asList(courses.split(" ")));
			Course_Student.addCourse_Student(dataSource, courseList, id);
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/deleteStudentDo", method = RequestMethod.GET)
	public @ResponseBody
	String deleteStudent(
            @RequestParam(value = "id", required = true) String id) {
		System.out.println(id);
		boolean result;
		try{
			result = Student.deleteStudent(dataSource, id);
			Student.viewStudent(dataSource);
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/enterAttendanceDo", method = RequestMethod.GET)
	public @ResponseBody
	String enterAttendance(
            @RequestParam(value = "courseId", required = true) String courseId,
            @RequestParam(value = "date", required = true) String date,
            @RequestParam(value = "studentList", required = true) String studentList) {
		System.out.println(courseId + "	" + date + "	" + studentList);
		boolean result;
		LinkedList<String> absentees = (studentList == null || studentList.isEmpty()) ? new LinkedList<String>() : new LinkedList<String>(Arrays.asList(studentList.split(" ")));
		try{
			result = EnterAttendance.enterAttendance(dataSource, courseId, date, absentees);
			EnterAttendance.viewAttendance(dataSource);
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/facultyAttendanceViewDo", method = RequestMethod.GET)
	public @ResponseBody
	String facultyAttendanceView(
            @RequestParam(value = "id", required = true) String id) {
		System.out.println(id);
		boolean result = false;
		try{
			//result = Student.deleteStudent(dataSource, id);
			//Student.viewStudent(dataSource);
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/studentAttendanceViewDo", method = RequestMethod.GET)
	public @ResponseBody
	String studentAttendanceView(
            @RequestParam(value = "id", required = true) String id) {
		System.out.println(id);
		boolean result = false;
		Attendance attendance;
		try{
			attendance = ViewAttendance.viewAttendance(dataSource, id);
			//Student.viewStudent(dataSource);
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
			attendance = null;
		}
		return gson.toJson(attendance);
	}
}