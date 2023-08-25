package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Connect {
	Connection con = null;

	public ArrayList<Employee> meth1() throws ClassNotFoundException, SQLException {
		ArrayList<Employee> alist = new ArrayList<>();
		Class.forName("org.postgresql.Driver");
		System.out.println("class");
		con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin",
				"pff123");
		System.out.println("connection");
		PreparedStatement ps = con.prepareStatement("select * from rjpro");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int empno = Integer.parseInt(rs.getString(1));
			String ename = rs.getString(2);
			String job = rs.getString(3);
			double sal = Double.parseDouble(rs.getString(5));
			int dept = Integer.parseInt(rs.getString(4));
			alist.add(new Employee(empno, ename, job, dept, sal));
		}
		return alist;
	}

	public int meth2(int a, String b, String c, double d, int e) throws SQLException {
		PreparedStatement ps = con.prepareStatement("insert into rjpro values(?,?,?,?,?)");
		ps.setInt(1, a);
		ps.setString(2, b);
		ps.setString(3, c);
		ps.setDouble(5, d);
		ps.setInt(4, e);
		int x = ps.executeUpdate();
		System.out.println(x);
		return x;
	}

	public int meth3(int a, String b, String c, double d, int e) throws SQLException {
		PreparedStatement ps = con.prepareStatement("update rjpro set ename=?,job=?,dept=?,sal=? where empno=?");
		ps.setInt(5, a);
		ps.setString(1, b);
		ps.setString(2, c);
		ps.setDouble(4, d);
		ps.setInt(3, e);
		int x = ps.executeUpdate();
		System.out.println(x);
		return x;
	}

	public void meth4(int a) throws SQLException {
		PreparedStatement ps = con.prepareStatement("delete from rjpro where empno=?");
		ps.setInt(1, a);
		ps.executeQuery();
	}
}
