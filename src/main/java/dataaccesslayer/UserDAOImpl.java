package dataaccesslayer;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import business.User;

public class UserDAOImpl implements UserDAO{

	public List<User> getUserById(String Id) {
		//DataConn conn=DataConn.getInstanceDataConn();
		 JdbcTemplate template = DataConn.getTemplate();
		 System.out.println("inside");
		  List query = template.query("select * from users where ID=?",new Object[]{Id},new UserRowMapper());
		  return query;
	}

}
