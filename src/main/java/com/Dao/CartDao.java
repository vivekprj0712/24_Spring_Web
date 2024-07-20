package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.CartBean;
import com.Bean.EProductBean;

@Repository
public class CartDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addToCart(CartBean cartBean) {
		stmt.update("insert into carts  (productId,userId) values(?,?)" , cartBean.getProductId() , cartBean.getUserId());
	}

	public List<EProductBean> myCart(Integer id) {
	  List<EProductBean> products =  stmt.query("SELECT * FROM PRODUCTS JOIN CARTS USING (PRODUCTID) WHERE USERID = ?", new BeanPropertyRowMapper<>(EProductBean.class), new Object[] {id});
		return products;
	}
	
	/*
	 * public List<CartBean> allCart(Integer id) { List<CartBean> carts =
	 * stmt.query("Select * From carts where userid = ?", new
	 * BeanPropertyRowMapper<>(CartBean.class) , new Object[] {id}); return carts; }
	 */
	
	public void deleteUserCart(Integer productId , Integer userId) {
		
		stmt.update("DELETE FROM CARTS WHERE productId = ? and userId = ?",productId , userId);
		
	}
}
