package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EUserController {

	@GetMapping("/ehome")
	public String eHome() {
	
		return "EComHome";
	}
}
