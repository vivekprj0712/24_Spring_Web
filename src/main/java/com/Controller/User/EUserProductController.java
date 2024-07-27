package com.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Bean.EProductBean;
import com.Bean.EcomBean;
import com.Bean.ProductCartBean;
import com.Dao.CartDao;
import com.Dao.EProductDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class EUserProductController {

	@Autowired
	EProductDao productDao;
	
	@Autowired
	CartDao cartDao;
	
	@GetMapping("/listuserproduct")
	public String listUserProducts(Model model, HttpSession session) {
		EcomBean dbUser = (EcomBean)session.getAttribute("user");
		List<EProductBean> products = productDao.allProduct();// return type
		List<ProductCartBean> cartProduct = cartDao.myCart(dbUser.getId());	
		model.addAttribute("products", products);
		model.addAttribute("cartProductSize", cartProduct.size());

		return "EcomeUserProduct";
	}
}
