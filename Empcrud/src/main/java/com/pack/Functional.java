package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Functional {
	Connection con;
	ResultSet rs;
	public void conn() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin", "pff123");
		
	}
	public JSONArray meth() throws SQLException {
		PreparedStatement ps=con.prepareStatement("select * from likhi_emp");
		rs=ps.executeQuery();
		JSONArray ja=new JSONArray();
		while(rs.next()) {
			JSONObject jo=new JSONObject();
			try {
				jo.put("num", rs.getString("empno"));
				jo.put("name",rs.getString("ename"));
				jo.put("jo", rs.getString("job"));
				jo.put("dep", rs.getString("dept"));
				jo.put("sa", rs.getString("sal"));
				ja.put(jo);
			} catch (JSONException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ja;
	}
	public JSONArray meth2(int empno,String ename,String job,int dept,double sal) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into likhi_emp values(?,?,?,?,?)");
		ps.setInt(1,empno);
		ps.setString(2, ename);
		ps.setString(3, job);
		ps.setInt(4, dept);
		ps.setDouble(5, sal); 
		ps.executeUpdate();
		
		JSONArray re=meth();
		return re;
	}
	public JSONArray meth3(int empno,String ename,String job,int dept,double sal) throws SQLException {
		PreparedStatement ps=con.prepareStatement("update likhi_emp set ename=?,job=?,dept=?,sal=? where empno=?");
		
		ps.setString(1, ename);
		ps.setString(2, job);
		ps.setInt(3, dept);
		ps.setDouble(4, sal); 
		ps.setInt(5,empno);
		ps.executeUpdate();
		
		JSONArray re=meth();
		return re;
	}
	public JSONArray meth4(int empno) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete  from likhi_emp where empno=? ");
		ps.setInt(1, empno);
		ps.executeUpdate();
		
		JSONArray re=meth();
		return re;
		
	}

}

