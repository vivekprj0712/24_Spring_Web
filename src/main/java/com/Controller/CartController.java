package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bean.CartBean;
import com.Bean.EProductBean;
import com.Bean.EcomBean;
import com.Bean.ProductCartBean;
import com.Dao.CartDao;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	CartDao cartDao;
	
	@GetMapping("/addtocart")
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
	
	@GetMapping("/usercart")
	public String userCart(HttpSession session, Model model) {
		
		EcomBean dbUser = (EcomBean)session.getAttribute("user");
		
		if(dbUser != null) {
			List<ProductCartBean> products = cartDao.myCart(dbUser.getId());
			model.addAttribute("products", products);
			model.addAttribute("userId" , dbUser.getId());
			return "UserCart";
		}else {
			return "redirect:/elogin";
		}
		
	}
	@GetMapping("removeusercart")
	public String removeUserCart(@RequestParam("cartId") Integer cartId) {
		cartDao.deleteUserCart(cartId);
		return "redirect:/usercart";
	}
	
	@GetMapping("minusqty")
	public String minusQty(@RequestParam("cartId") Integer cartId) {
		
		
		cartDao.minusQty(cartId);
		return "redirect:/usercart";
	}
	
	@GetMapping("plusqty")
	public String plusQty(@RequestParam("cartId") Integer cartId) {
		
		cartDao.plusQty(cartId);
		return "redirect:/usercart";
	}
	
	
}
