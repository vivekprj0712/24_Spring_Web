package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EProductBean;

@Repository
public class EProductDao {

	
	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(EProductBean productBean) {
		stmt.update("INSERT INTO PRODUCTS(PRODUCTNAME , CATEGORY , QTY , PRICE) VALUES(?,?,?,?) ",productBean.getProductName() , productBean.getCategory() , productBean.getQty() , productBean.getPrice());
	}

	public List<EProductBean> allProduct() {
		List<EProductBean> products =stmt.query("SELECT * FROM PRODUCTS", new BeanPropertyRowMapper<EProductBean>(EProductBean.class));
		return products;
	}

	public void deleteProduct(Integer productId) {
		stmt.update("DELETE FROM PRODUCTS WHERE PRODUCTID=?",productId);
		
	}

	public void deleteProductName(String productName) {
		
		stmt.update("DELETE FROM PRODUCTS WHERE PRODUCTNAME=?",productName);
		
	}
	  
	
	
	
	
}
