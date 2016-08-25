package com.attendance.portal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class AppConfig {
	
	@Bean 
	public Gson testGson(){
		System.out.println("\n\n\n\n\n\n\n\n Gson Bean Created !!! \n\n\n\n\n\n\n\n");
	   return new Gson();
	}
}
