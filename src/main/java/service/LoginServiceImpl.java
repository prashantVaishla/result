package service;

import java.util.List;

import org.springframework.stereotype.Service;

import business.User;
import business.UserTO;
import dataaccesslayer.UserDAOImpl;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	public void authenticate(UserTO userTO) throws Exception{
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		List<User> userById = userDAOImpl.getUserById(userTO.getUsername());
		if (!userById.isEmpty()) {
			User user = userById.get(0);
			if (!user.getPwd().equals(userTO.getPwd()))
				throw new Exception("Ivalid credentials");//some custom exception
		} else
			throw new Exception("No such user");
	}
}
