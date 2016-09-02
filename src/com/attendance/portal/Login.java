package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;



public class Login {
	public Validation validate(DataSource db,String Username, String Password) throws SQLException{
		Connection conn = db.getConnection();
		String s = "SELECT Password,Type FROM Login WHERE Id = ?";
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1,Username);
		ResultSet rs = p.executeQuery();
		String Pass = null;
		String AccountType = null;
		while(rs.next()){
			Pass = rs.getString("Password");
			AccountType = rs.getString("Type");
		}
		if(Pass.equals(Password)){
			return new Validation(true, AccountType);
		}
		else{
			return new Validation(false, null);
		}
		
	}
}
