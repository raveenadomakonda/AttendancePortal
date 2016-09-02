package com.attendance.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;



public class Login {
	public Validation validate(DataSource db,String username, String password) throws SQLException{
		Connection conn = db.getConnection();
		String s = "SELECT Password,Type FROM Login WHERE Id = ?";
		PreparedStatement p = conn.prepareStatement(s);
		p.setString(1,username);
		ResultSet rs = p.executeQuery();
		String pass = null;
		String accountType = null;
		while(rs.next()){
			pass = rs.getString("Password");
			accountType = rs.getString("Type");
		}
		if(pass.equals(password)){
			return new Validation(true, accountType);
		}
		else{
			return new Validation(false, null);
		}
		
	}
}
