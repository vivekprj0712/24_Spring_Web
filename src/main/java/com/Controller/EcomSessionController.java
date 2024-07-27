package com.Controller;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.EcomBean;
import com.Dao.EcomDao;
import com.Services.FileUploading;

import jakarta.servlet.http.HttpSession;

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
		
		ebean.setProfilePath("ProfileImage//" + ebean.getEmail() + "//" + ebean.getProfilePic().getOriginalFilename());
		edao.insertUser(ebean);
		fileUpload.userProfileImage(ebean.getProfilePic(),ebean.getEmail());	
		return "EcomLogin";
	}
	
	@GetMapping(value = {"/","elogin"})
	public String welcome() {
		return "EcomLogin";
	}
	
	@PostMapping("/elogin")
	public String ELogin(EcomBean ebean , Model model , HttpSession session){
		
		System.out.println(ebean.getEmail());
		System.out.println(ebean.getPassword());

		EcomBean dbUser = edao.authenticate(ebean.getEmail() , ebean.getPassword());

		if(dbUser == null) {
			model.addAttribute("error" , "Invalid Email or Password");
			return "EcomLogin";
		}
		else {
			System.out.println(dbUser.getProfilePath());
			session.setAttribute("user", dbUser);
			session.setMaxInactiveInterval(60*10);
			model.addAttribute("name",dbUser.getUserName());
			model.addAttribute("img", dbUser.getProfilePath());
			return "EComHome";
		}	
	}
	
}
