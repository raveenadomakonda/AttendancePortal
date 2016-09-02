package com.attendance.portal;

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
}