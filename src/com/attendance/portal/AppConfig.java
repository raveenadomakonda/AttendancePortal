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
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
			//.addScript("db/sql/create-db.sql") //Add these later when you have your schema figured out raveena
			//.addScript("db/sql/insert-data.sql")
			.build();
		System.out.println("\n\n\n\n\n\n\n\n DB Bean Created !!! \n\n\n\n\n\n\n\n");

		return db;
	}
}
