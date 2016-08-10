package com.usbrazilworkshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.google.gson.Gson;

@Configuration
public class AppConfig {
	
	@Bean 
	public Gson testGson(){
		System.out.println("\n\n\n\n\n\n\n\n Gson Bean Created !!! \n\n\n\n\n\n\n\n");
	   return new Gson();
	}
	
	@Bean 
	public DBDao dbDao(){
	   System.out.println("\n\n\n\n\n\n\n\n DBDAO Bean Created !!! \n\n\n\n\n\n\n\n");
	   return new DBDao();
	}
	
	@Bean 
	public S3Dao s3dao(){
	   System.out.println("\n\n\n\n\n\n\n\n S3DAO Bean Created !!! \n\n\n\n\n\n\n\n");
	   return new S3Dao();
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	    commonsMultipartResolver.setDefaultEncoding("utf-8");
	    commonsMultipartResolver.setMaxUploadSize(50000000);
	    return commonsMultipartResolver;
	}
	
	/*@Bean
	public MultipartConfigElement multipartResolver(){
	    MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
	    multipartConfigFactory.setMaxFileSize("10MB");
	    multipartConfigFactory.setMaxRequestSize("50MB");
	    return multipartConfigFactory.createMultipartConfig();
	}*/
	
	
	
}
