package com.result.dataaccesslayer.user;

import java.util.List;

import com.result.businessLayer.user.User;

public interface UserDAO {
	
	public List<User> getUserById(String Id);
		
}
