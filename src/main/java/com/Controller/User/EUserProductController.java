package com.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Bean.EProductBean;
import com.Dao.EProductDao;

@Controller
public class EUserProductController {

	@Autowired
	EProductDao productDao;

	@GetMapping("/listuserproduct")
	public String listUserProducts(Model model) {
		List<EProductBean> products = productDao.allProduct();// return type

		model.addAttribute("products", products);

		return "EcomeUserProduct";
	}
}
