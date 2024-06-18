package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.GetExchange;

import com.Bean.EProductBean;
import com.Dao.EProductDao;

@Controller
public class EProductController {

	@Autowired
	EProductDao productDao;
	
	@GetExchange("/newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean) {
		productDao.addProduct(productBean);
		return "ListProduct";
	}
}
