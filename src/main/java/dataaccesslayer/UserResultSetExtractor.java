package dataaccesslayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import business.User;

public class UserResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		User user=new User();
		user.setId(rs.getString("ID"));
		user.setPwd(rs.getString("PASSWORD"));
		return user;
	}

}
