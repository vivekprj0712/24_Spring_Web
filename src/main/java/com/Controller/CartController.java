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
			List<EProductBean> products = cartDao.myCart(dbUser.getId());	
			model.addAttribute("products", products);
			model.addAttribute("userId" , dbUser.getId());
			/* List<CartBean> carts = cartDao.allCart(dbUser.getId()); */
			/* model.addAttribute("carts", carts); */
			return "UserCart";
		}else {
			return "redirect:/elogin";
		}
		
	}
	@GetMapping("removeusercart")
	public String removeUserCart(@RequestParam("productId") Integer productId , @RequestParam("userId") Integer userId) {
		cartDao.deleteUserCart(productId,userId);
		return "redirect:/usercart";
	}
	
}
