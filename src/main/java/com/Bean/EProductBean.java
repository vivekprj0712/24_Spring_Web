package com.Bean;

import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

public class EProductBean {

	@Id
	private Integer productId;
	private String productName;
	private String category;
	private Integer qty;
	private Float price;
	private MultipartFile productPic;
	private String productPicPath;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public MultipartFile getProductPic() {
		return productPic;
	}
	public void setProductPic(MultipartFile productPic) {
		this.productPic = productPic;
	}
	public String getProductPicPath() {
		return productPicPath;
	}
	public void setProductPicPath(String productPicPath) {
		this.productPicPath = productPicPath;
	}
	
	
}
