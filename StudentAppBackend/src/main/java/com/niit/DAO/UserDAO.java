package com.niit.DAO;

import java.util.List;

import com.niit.dto.User;

public interface UserDAO {
	
	void registerUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(String username);

	public void updateUser(User user);
	
}
