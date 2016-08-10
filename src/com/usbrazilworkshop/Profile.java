package com.usbrazilworkshop;

public class Profile {
	String name;
	String position;
	String organization;
	String email;
	String researchArea;
	String bio;
	String photoUrl;
	
	public Profile(String name, String position, String organization, String email, String researchArea, String bio,
			String photoUrl) {
		
		this.name = name;
		this.position = position;
		this.organization = organization;
		this.email = email;
		this.researchArea = researchArea;
		this.bio = bio;
		this.photoUrl = photoUrl;		
		System.out.println(name + " " + position + " " + organization + " " + email + " " + researchArea + " " + bio + " " + photoUrl);
	}
	
	public void print(){
		System.out.println(name + " " + position + " " + organization + " " + email + " " + researchArea + " " + bio + " " + photoUrl);
	}
}
