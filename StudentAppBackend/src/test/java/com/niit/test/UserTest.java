package com.niit.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.dto.Blog;
import com.niit.dto.User;

public class UserTest {
	public static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
	/*@Test
	public  void addUserTest() {
		UserDetail user =new UserDetail();
		user.setUsername("shweta");
		user.setFirstname("shweta");
		user.setLastname("chaudhari");
		user.setPassword("123456");
		user.setEmail("sc@gmail.com");
		user.setOnline(true);
		user.setRole("Admin");
		
		assertTrue("Problm occure",userDAO.registerUser(user));
		
		
	}*/

	
	
	
	
	
	
	
}

