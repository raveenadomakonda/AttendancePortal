package com.usbrazilworkshop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ResultSetParser {
	
	public static List<Profile> parseProfiles(ResultSet resultSet) throws SQLException{
		LinkedList<Profile> profiles = new LinkedList<Profile>();
		while(resultSet.next()) {
			String name = resultSet.getString("Name");
			String position= resultSet.getString("Position");
			String organization = resultSet.getString("Organization");
			String email= resultSet.getString("Email");
			String researchArea= resultSet.getString("ResearchArea");
			String bio = resultSet.getString("Bio");
			String photoUrl= resultSet.getString("PhotoUrl");
			Profile entry = new Profile(name, position, organization, email, researchArea, bio, photoUrl);
			profiles.add(entry);
		}
		return profiles;
	}
}
