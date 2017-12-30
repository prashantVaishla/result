package dataaccesslayer;

import org.springframework.jdbc.core.JdbcTemplate;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import business.Emp;
public class DataConn {
	
	private static  JdbcTemplate template;
	//private static DataConn dataConn;
	
	/*private DataConn(){
		
	}
	private DataConn(JdbcTemplate template,DataConn dataConn){
		this.template=template;
		this.dataConn=dataConn;
	}
	
	public static DataConn getInstanceDataConn(){
		if(dataConn==null){
			return new DataConn();
		}else
			return dataConn;
	}*/
	public static JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	
	
//	public int save(Emp p){
//		String sql="insert into employee(name,Designation,ID,Salary)"
//				+ "values("+p.getName()+","+p.getDesignation()+","+p.getId()+","+p.getSalary()+")";
//		return template.update(sql);
//	}
//	
//	public int update(Emp p){
//		String sql="update Emp set name="+p.getName()+",Designation="+p.getDesignation()+",Salary="+p.getSalary()+"where ID="+p.getId()+";";
//		return template.update(sql);
//	}
//	public int delete(int id){
//		String sql="delete from employee where ID="+id+"";
//		return template.update(sql);
//	}
//	public Emp getEmpById(int id){
//		String sql="select * from employee where id=?";
//		return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Emp>(Emp.class));
//	}
//	public List<Emp> getEmployees(){
//		return template.query("select * from employee", new RowMapper<Emp>(){
//			public Emp mapRow(ResultSet rs,int row) throws SQLException{
//				Emp e=new Emp();
//				e.setName(rs.getString(1));
//				e.setDesignation(rs.getString(2));
//				e.setId(rs.getInt(3));
//				e.setSalary(rs.getFloat(4));
//				return e;
//			}
//		});
//	}
//
}
