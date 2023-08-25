package com.pack;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class Jdbc {
		Connection con;
		ResultSet rs;
		
		Jdbc() throws ClassNotFoundException, SQLException { 
		Class.forName("org.postgresql.Driver");
		 con=DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin", "pff123");	
		System.out.println("connection established");
		}
		
		public String meth1(String name) throws SQLException {
			PreparedStatement ps=con.prepareStatement("Select password from employee_pass where ename=?");
			ps.setString(1,name );

			rs=ps.executeQuery();
			String pass = null;
			if(rs.next()) {
				pass=rs.getString("password");
				}
			System.out.println(pass);
			return pass;
			
			
		}


	}



