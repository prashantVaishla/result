package dataaccesslayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import business.*;
public class EmpDao {
	//DataConn connObj=DataConn.getInstanceDataConn();
	
	public User getEmpById(String username){
		String sql="select * from employee where id=?";
		return DataConn.getTemplate().queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<User>(User.class));
	}
	
//	public List<User> getEmployees(){
//		return connObj.template.query("select * from employee", new RowMapper<User>(){
//			public User mapRow(ResultSet rs,int row) throws SQLException{
//				User u=new User();
//				u.setId(rs.getString(1));
//				u.setPwd(rs.getString(2));
//				u.setType(rs.getString(3));
//				u.setSession(rs.getString(4));
//				return u;
////				e.setName(rs.getString(1));
////				e.setDesignation(rs.getString(2));
////				e.setId(rs.getInt(3));
////				e.setSalary(rs.getFloat(4));
////				return e;
//			}
//		});
//	}
}
