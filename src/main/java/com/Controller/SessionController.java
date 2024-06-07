package com.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.ui.Model;

import com.Bean.SumBean;
import com.Bean.UserBean;


@Controller
public class SessionController {

	
	@GetMapping("/login")
	public String login()
	{
		return "Login";
	}
	
	@GetMapping("/signup")
	public String signup()
	{
		return "Signup";
	}
	
	@GetMapping("/forgetpassword")
	public String forgetPassword()
	{
		return "ForgetPassword";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(UserBean userBean ,Model model)
	{
		System.out.println("FirstName: " + userBean.getFirstName());
		System.out.println("LastName: " + userBean.getLastName());
		System.out.println("Email: " + userBean.getEmail());
		System.out.println("Password: " + userBean.getPassword());
		
		model.addAttribute("user", userBean);
		
		return "Home";
	}
	@GetExchange("/sum")
	public String sum()
	{
		return "Sum";
	}
	@PostMapping("/add")
	public String add(SumBean sumBean , Model model)
	{
		Integer sum = sumBean.getNo1() + sumBean.getNo2();
		model.addAttribute("sum", sum);
		model.addAttribute("sumBean", sumBean);
		return "Add";
	}
}
