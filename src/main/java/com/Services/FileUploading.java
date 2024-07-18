package com.Services;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploading {

	
	public void fileUpload(MultipartFile masterImage ) {
		
		String path = "C:\\Royal\\Internship with Tejas Sir\\24-online-admission\\24-spring-web\\src\\main\\webapp\\Images";
		
		try {
	
			File img = new File(path,masterImage.getOriginalFilename());
		 FileUtils.writeByteArrayToFile(img,masterImage.getBytes()); 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void userProfileImage(MultipartFile masterImage , String email) {
		
			String path = "C:\\Royal\\Internship with Tejas Sir\\24-online-admission\\24-spring-web\\src\\main\\webapp\\ProfileImage";
			File dir = new File(path,email);
			dir.mkdir();
		
		try {
	
			File img = new File(dir,masterImage.getOriginalFilename());
			FileUtils.writeByteArrayToFile(img,masterImage.getBytes()); 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
