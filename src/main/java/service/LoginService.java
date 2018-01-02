package service;

import business.UserTO;

public interface LoginService {
	public void authenticate(UserTO userTO) throws Exception;

}
