package com.result.dataaccesslayer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.result.businessLayer.*;
import com.result.businessLayer.user.User;
public class EmpDao {
	
	public User getEmpById(String username){
		String sql="select * from employee where id=?";
		return DataConn.getTemplate().queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<User>(User.class));
	}

}
