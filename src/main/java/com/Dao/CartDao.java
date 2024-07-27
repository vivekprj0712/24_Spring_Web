package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.CartBean;
import com.Bean.EProductBean;
import com.Bean.ProductCartBean;

@Repository
public class CartDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addToCart(CartBean cartBean) {
		
		CartBean cart = null;
		 try {
			 cart =  stmt.queryForObject("select * from carts where productId = ? and userId = ?", new BeanPropertyRowMapper<>(CartBean.class) , new Object[] {cartBean.getProductId() , cartBean.getUserId()});
			 
		 }catch (Exception e) {
			e.printStackTrace();
		}
		if(cart == null) {
			stmt.update("insert into carts  (productId,userId,qty) values(?,?,?)" , cartBean.getProductId() , cartBean.getUserId(), 1);
		}else {
			stmt.update("update carts set qty = ? where productId = ? and userId = ? ", cart.getQty() + 1, cart.getProductId(), cart.getUserId());
		}
	}

	public List<ProductCartBean> myCart(Integer id) {
	  List<ProductCartBean> products =  stmt.query("SELECT p.productName , p.productPicPath , p.price , p.category , c.qty , c.cartId FROM PRODUCTS p JOIN CARTS c USING (PRODUCTID) WHERE USERID = ?", new BeanPropertyRowMapper<>(ProductCartBean.class), new Object[] {id});
		return products;
	}
	
	 
	
	public void deleteUserCart(Integer cartId) {
		
		stmt.update("DELETE FROM CARTS WHERE cartId = ?",cartId);
		
	}

	public void minusQty(Integer cartId) {
		CartBean qty = null;
		try {
			qty = stmt.queryForObject("select * from carts where cartId = ?", new BeanPropertyRowMapper<>(CartBean.class) , new Object[] {cartId});

		}catch (Exception e) {
			e.printStackTrace();
		}
		if(qty.getQty() != 1) {
		
			stmt.update("UPDATE CARTS SET QTY = ? where cartId = ?" , qty.getQty()-1 ,  cartId);
		  }
		else {
			stmt.update("DELETE FROM CARTS WHERE cartId = ?",cartId);
		}
	}

	public void plusQty(Integer cartId) {
		CartBean qty = null;
		try {
			qty = stmt.queryForObject("select * from carts where cartId = ?", new BeanPropertyRowMapper<>(CartBean.class) , new Object[] {cartId});

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		stmt.update("UPDATE CARTS SET QTY = ? where cartId = ?" , qty.getQty()+ 1 ,  cartId);

	}
}
