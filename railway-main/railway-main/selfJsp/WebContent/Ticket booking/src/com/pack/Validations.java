package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validations {
	Connection con;

	ResultSet connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
				"plf_training_admin", "pff123");
		PreparedStatement ps = con.prepareStatement("select * from validation");
		ResultSet rs = ps.executeQuery();
		return rs;
	}

}
