package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EcomBean;

@Repository
public  class EcomDao {

	@Autowired //instance eject
	JdbcTemplate stmt;
	
	public  void insertUser(EcomBean ebean) {
	
		stmt.update("INSERT INTO USERS(USERNAME , EMAIL , PASSWORD ,PROFILEPATH) VALUES(?,?,?,?) ", ebean.getUserName() , ebean.getEmail() , ebean.getPassword(),ebean.getProfilePath());
		
		
	}

	public EcomBean authenticate(String email, String password) {
		try {
			EcomBean userBean =  stmt.queryForObject("SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?", new BeanPropertyRowMapper<>(EcomBean.class) , new Object[] {email,password});
			return userBean;
		}catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
}
