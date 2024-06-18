package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
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
}
