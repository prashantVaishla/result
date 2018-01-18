package com.result.dataaccesslayer;

import org.springframework.jdbc.core.JdbcTemplate;
public class DataConn {
	
	private static  JdbcTemplate template;
	public static JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	
}