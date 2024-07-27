package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.EcomBean;
import com.Bean.ProductCartBean;
import com.Dao.CartDao;

import jakarta.servlet.http.HttpSession;


@Controller
public class PaymentController {

	@Autowired
	CartDao cartDao;
	
	@GetMapping("checkout")
	public String payment(HttpSession session, Model model) {
		
		EcomBean dbUser = (EcomBean) session.getAttribute("user");
		if(dbUser != null) {
			List<ProductCartBean> products = cartDao.myCart(dbUser.getId());
			model.addAttribute("products", products);
			model.addAttribute("userId" , dbUser.getId());
			return "Payment";
		}else {
			return "redirect:/elogin";
		}
	}
	
	
}
