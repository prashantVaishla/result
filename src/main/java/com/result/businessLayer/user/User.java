package com.result.businessLayer.user;


public class User {
	private String id;
	private String pwd;
	private String type;
	private String session;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	
	public String toString(){
		return "{ID="+id+",Type="+type+"}";
	}
}
