package com.usbrazilworkshop;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.google.gson.Gson;



@Controller
public class Controllers {
	
	@Autowired DBDao dbDao;
	@Autowired Gson gson;
	@Autowired S3Dao s3Dao;
	
	
	@RequestMapping(value = "/uploadProfile", method = RequestMethod.POST)
	public @ResponseBody
	String updateProfile(@RequestBody String data) {
		System.out.println(data);
		boolean result = false;
		// Update DB
		try{
			result = dbDao.addProfile(data,"BR"); // change to "US" after the brazilia workshop
		}
		catch(Exception e){
			e.printStackTrace();
			return gson.toJson(new ResultMessage(result));
		}
		System.out.println("Return val-"+result);
		return gson.toJson(new ResultMessage(result));

	}
	
	@RequestMapping(value = "/getProfilesUS", method = RequestMethod.GET)
	public @ResponseBody
	String getProfilesUS() {
		List<Profile> profiles = dbDao.getProfiles("US");
		return gson.toJson(profiles);

	}
	
	@RequestMapping(value = "/getProfilesBR", method = RequestMethod.GET)
	public @ResponseBody
	String getProfilesBR() {
		List<Profile> profiles = dbDao.getProfiles("BR");
		return gson.toJson(profiles);

	}
	
	@RequestMapping(value="/uploadPicture", method=RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
        	System.out.println("Got file!!! size: "+file.getSize()+" bytes");
            try {
                byte[] bytes = file.getBytes();
                File tempFile = File.createTempFile("tempPicFile", ".jpg");
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(tempFile));
                stream.write(bytes);
                stream.close();
                String link = s3Dao.uploadFile(tempFile);
                tempFile.deleteOnExit();
                return "{ \"link\": \""+link+"\"}";// + name + "!";
            } catch (Exception e) {
                return "{ 'data' : 'You failed to upload'} ";// + name + " => " + e.getMessage();
            }
        } else {
            return "{ 'data': 'You failed to upload' }";// + name + " because the file was empty.";
        }
    }

	

}