package com.attendance.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class Controllers {
	
	@Autowired Gson gson;
	
	@RequestMapping(value = "/sampleRestApi", method = RequestMethod.GET)
	public @ResponseBody
	String exampleFunction() {
		String text = "Server says hi!";
		
		
		return gson.toJson(text);
	}
}