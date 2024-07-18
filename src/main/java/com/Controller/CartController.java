package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.CartBean;
import com.Bean.EcomBean;
import com.Dao.CartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	CartDao cartDao;
	
	@GetMapping("addtocart")
	public String addToCart(@RequestParam("productId") Integer productId , HttpSession session) {
		
		EcomBean comBean = (EcomBean)session.getAttribute("user");
		System.out.println("Value:"+comBean.getId());
		CartBean cartBean = new CartBean();
		Integer userId = comBean.getId();
		cartBean.setProductId(productId);
		cartBean.setUserId(userId);
		cartDao.addToCart(cartBean);	
		return "redirect:/listuserproduct";
	}
}
