package com.attendance.portal;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.google.gson.Gson;

@Configuration
public class AppConfig {
	
	@Bean 
	public Gson testGson(){
		System.out.println("\n\n\n\n\n\n\n\n Gson Bean Created !!! \n\n\n\n\n\n\n\n");
		return new Gson();
	}
	
	@Bean
	public DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		DataSource db = DBUtil.dataSource();
		try{
			DBUtil.createTable(db);
			DBTestData.setupTestData(db);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n\n\n\n\n DB Bean Created !!! \n\n\n\n\n\n\n\n");
		return db;
	}
	
	@Bean
	public Login loginHandler(){
		return new Login();
	}
}
