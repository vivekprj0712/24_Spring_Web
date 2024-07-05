package com.Controller;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.EcomBean;
import com.Dao.EcomDao;
import com.Services.FileUploading;

@Controller
public class EcomSessionController {

	@Autowired
	EcomDao edao;
	
	@Autowired
	FileUploading fileUpload;
	
	@GetMapping("/esignup")
	public  String  EsignupGet() {
		
		return "EcomSignup";
	}
	@PostMapping("/esignup")
	public String EsignupPost(EcomBean ebean) {
		
		String masterPath = "C:\\Royal\\Internship with Tejas Sir\\24-online-admission\\24-spring-web\\src\\main\\resources\\ProfileImage";
		ebean.setProfilePicPath(masterPath + "\\" + ebean.getEmail() + "\\" + ebean.getProfilePic().getOriginalFilename());
		edao.insertUser(ebean);
		fileUpload.userProfileImage(ebean.getProfilePic(),ebean.getEmail(),  masterPath);
		
		return "EcomLogin";
	}
}
