package com.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.EcomBean;

@Repository
public  class EcomDao {

	@Autowired //instance eject
	JdbcTemplate stmt;
	
	public  void insertUser(EcomBean ebean) {
	
		stmt.update("INSERT INTO USERS(USERNAME , EMAIL , PASSWORD ,PROFILEPATH) VALUES(?,?,?,?) ", ebean.getUserName() , ebean.getEmail() , ebean.getPassword(),ebean.getProfilePicPath());
		
		
	}
}
