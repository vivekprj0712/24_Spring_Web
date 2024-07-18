package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.CartBean;

@Repository
public class CartDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addToCart(CartBean cartBean) {
		stmt.update("insert into carts  (productId,userId) values(?,?)" , cartBean.getProductId() , cartBean.getUserId());
	}
	
}
