package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.GetExchange;

import com.Bean.EProductBean;
import com.Dao.EProductDao;
import com.Services.FileUploading;

@Controller
public class EProductController {

	@Autowired
	EProductDao productDao;
	
	@Autowired
	FileUploading fileUploading;
	
	@GetExchange("/newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean) {
		
		productBean.setProductPicPath("\\Images\\" + productBean.getProductPic().getOriginalFilename());
		productDao.addProduct(productBean);		
		fileUploading.fileUpload(productBean.getProductPic());
		return "redirect:/listproduct";
	}
	@GetMapping("/listproduct")
	public String listProduct(Model model) {
		List<EProductBean> products =  productDao.allProduct();
		model.addAttribute("products", products);
		return"ListProduct";
	}
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("PRODUCTID") Integer productId) {
		
		productDao.deleteProduct(productId);
		return "redirect:/listproduct";
	}
	
	@GetMapping("/productname")
	public String productName() {
		return "DeleteProductName";
	}
	
	@PostMapping("/deleteproductname")
	public String deleteProductName(EProductBean productBean) {
		productDao.deleteProductName(productBean.getProductName());
		return "redirect:/listproduct";
	}
	
	@GetMapping("/viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId , Model model) {
		
		EProductBean product = productDao.viewProduct(productId);
		model.addAttribute("product", product);
		return "ViewProduct";
	}
}
