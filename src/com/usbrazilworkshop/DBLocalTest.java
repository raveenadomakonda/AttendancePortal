package com.usbrazilworkshop;

import java.io.File;
import java.util.List;

public class DBLocalTest {
	public static void main(String[] Args){
		/*DBDao dao = new DBDao();
		List<Profile> profiles = dao.getProfiles();
		for(Profile entry: profiles){
			entry.print();
		}*/
		S3Dao dao = new S3Dao();
		dao.listBuckets();
		File file = new File("/home/aditya/Downloads/2015-10-01.jpg");
		dao.uploadFile(file);
	}
}
