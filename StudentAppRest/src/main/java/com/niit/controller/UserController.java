package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.UserDAO;
import com.niit.dto.User;
import com.niit.model.ErrorClazz;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user){
	try{
		if(!userDAO.isUsernameValid(user.getUsername())){ //not allow duplicate username
			ErrorClazz error = new ErrorClazz(2, "Username already exists..Please choose different username");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.CONFLICT);//conflict 200-299status
			
		}
		if(!userDAO.isEmailValid(user.getEmail())){
			ErrorClazz error = new ErrorClazz(3, "EmailId already exists..Please choose different email address");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.CONFLICT);//conflict 200-299status
		}
		userDAO.registerUser(user);
	}
	catch(Exception e)
	{
		ErrorClazz error = new ErrorClazz(1, "Unable to register user details");
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		//failure -response.data=error,response.status=500
	}
	return new ResponseEntity<User>(user,HttpStatus.OK);
}
	
	
}
