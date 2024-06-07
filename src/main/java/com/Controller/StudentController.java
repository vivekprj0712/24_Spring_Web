package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bean.StudentBean;
import com.Util.Validators;

@Controller
public class StudentController {

	@GetMapping("/newstudent")
	public String newStudent()
	{
		return "BoxCricketReg";
	}
	
	@PostMapping("/savestudent")
	public String saveStudent(StudentBean studentBean , Model model)
	{
		boolean isError = false;
		
		if(Validators.isBlank(studentBean.getStudentName()))
		{
			model.addAttribute("studentNameError", "Please Enter Name");
			isError = true;
		}
		else if(Validators.isAlpha(studentBean.getStudentName()))
			{
				model.addAttribute("studentNameError", "Please Enter Valid Name");
				isError = true;
			}
		if(Validators.isBlank(studentBean.getPlayingType()))
		{
			model.addAttribute("playingTypeError", "Please Select Playing Type");
			isError = true;
		}
		if(Validators.isBlank(studentBean.getFood()))
		{
			model.addAttribute("foodError", "Please Select Food");
			isError = true;
		}
		if(Validators.isBlank(studentBean.getCoolDrink()))
		{
			model.addAttribute("coolDrinkError", "Please Select CoolDrink");
			isError = true;
		}
		
		model.addAttribute("studentBean", studentBean);
		if(isError)
		{
			return "BoxCricketReg";
		}
		else {
		System.out.println("StudentName: " + studentBean.getStudentName());
		System.out.println("Playing Type: " + studentBean.getPlayingType());
		System.out.println("Food: " + studentBean.getFood());
		System.out.println("CoolDrinks :" + studentBean.getCoolDrink());
//		model.addAttribute("studentBean", studentBean);
		return "ListStudent";
		}
	}
}
