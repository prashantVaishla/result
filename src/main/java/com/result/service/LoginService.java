/**
 * 
 */
package com.result.service;

import com.result.businessLayer.user.User;

/**
 * @author prashant
 *
 */
public interface LoginService {

	public void authenticate(User user) throws Exception;
}
