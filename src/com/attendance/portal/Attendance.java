package com.attendance.portal;

public class Attendance {
	public final int totalPresent;
	public final int totalClasses;
	public final String sub1;
	public final String sub2; 
	public final String sub3;
	public final String sub4;
	public final String sub5;
	public final String sub6; 
	public final int Sub1Total;
	public final int Sub1Present;
	public final int Sub2Total;
	public final int Sub2Present;
	public final int Sub3Total;
	public final int Sub3Present;
	public final int Sub4Total;
	public final int Sub4Present;
	public final int Sub5Total;
	public final int Sub5Present;
	public final int Sub6Total;
	public final int Sub6Present;
	public final String name;
	public final float percentage;
	
	public Attendance(int totalPresent, int totalClasses, String sub1,
			String sub2, String sub3, String sub4, String sub5, String sub6,
			int sub1Total, int sub1Present, int sub2Total, int sub2Present,
			int sub3Total, int sub3Present, int sub4Total, int sub4Present,
			int sub5Total, int sub5Present, int sub6Total, int sub6Present,
			String name, float percentage) {
		
		this.totalPresent = totalPresent;
		this.totalClasses = totalClasses;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
		this.sub6 = sub6;
		this.Sub1Total = sub1Total;
		this.Sub1Present = sub1Present;
		this.Sub2Total = sub2Total;
		this.Sub2Present = sub2Present;
		this.Sub3Total = sub3Total;
		this.Sub3Present = sub3Present;
		this.Sub4Total = sub4Total;
		this.Sub4Present = sub4Present;
		this.Sub5Total = sub5Total;
		this.Sub5Present = sub5Present;
		this.Sub6Total = sub6Total;
		this.Sub6Present = sub6Present;
		this.name = name;
		this.percentage = percentage;
	}
	
}
	