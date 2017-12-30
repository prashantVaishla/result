package dataaccesslayer;

import java.util.List;

import business.User;

public interface UserDAO {
	
	public List<User> getUserById(String Id);
		
}
