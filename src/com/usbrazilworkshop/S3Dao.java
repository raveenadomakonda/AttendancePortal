package com.usbrazilworkshop;

import java.io.File;
import java.util.Random;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Dao {
	
	AmazonS3 s3client;
	private static String bucketName     = "usbrazilcybersecurityworkshop";
	
	public S3Dao(){
		String accessKeyId = "AKIAISF5TUSRCHBFUNJQ";
        String secretAccessKey = "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";
        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
        s3client = new AmazonS3Client(credentials);
	}
	
	public void listBuckets(){
		for (Bucket bucket : s3client.listBuckets()) {
			System.out.println(" Bucket Name - " + bucket.getName());
		}
	}
	
	public String uploadFile(File file){
		String key = getRandomFileName();
		String linkPrefix = "http://s3-us-west-2.amazonaws.com/usbrazilcybersecurityworkshop/";
		String link = linkPrefix + key;
		try{
			PutObjectRequest por = new PutObjectRequest(bucketName, key, file);
			por.setCannedAcl(CannedAccessControlList.PublicRead);
			s3client.putObject(por);
			//s3client.putObject(new PutObjectRequest(bucketName, key, file));
			System.out.println("Put file in S3 bucket. File name: " + key +" \nLink: " + link);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return link;
	}
	
	private String getRandomFileName(){
		Random rand = new Random();
		String fileName = "";
		for(int i=0;i<10;i++){
			int randNum = rand.nextInt(1000);
			fileName = fileName + Integer.toString(randNum);
		}
		
		return fileName+".jpg";
	}
}
