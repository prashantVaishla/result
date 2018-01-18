package com.result.dataaccesslayer.user;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.result.businessLayer.user.User;
import com.result.dataaccesslayer.DataConn;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	public List<User> getUserById(String Id) {
		 JdbcTemplate template = DataConn.getTemplate();
		 System.out.println("inside");
		  List query = template.query("select * from users where ID=?",new Object[]{Id},new UserRowMapper());
		  return query;
	}

}
