package com.result.dataaccesslayer.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.result.businessLayer.user.User;

public class UserResultSetExtractor implements ResultSetExtractor{
	/*@Autowired
	@Qualifier("user")
	private User user;*/
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		User user=new User();
		user.setId(rs.getString("ID"));
		user.setPwd(rs.getString("PASSWORD"));
		return user;
	}

}
