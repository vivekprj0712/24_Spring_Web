package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.EcomBean;
import com.Dao.EcomDao;

@Controller
public class EcomSessionController {

	@Autowired
	EcomDao edao;
	
	@GetMapping("/esignup")
	public  String  EsignupGet() {
		
		return "EcomSignup";
	}
	@PostMapping("/esignup")
	public String EsignupPost(EcomBean ebean) {
		
		edao.insertUser(ebean);
		return "EcomLogin";
	}
}
