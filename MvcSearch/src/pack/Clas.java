package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Clas {
	Connection con;
	ResultSet rs;

	public Connection meth1() throws ClassNotFoundException, SQLException {
		ArrayList<Employee> alist = new ArrayList<>();
		Class.forName("org.postgresql.Driver");
		System.out.println("class");
		con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin",
				"pff123");
		return con;
		// System.out.println("connection");
		// PreparedStatement ps = con.prepareStatement("select * from rjpro");
		// ResultSet rs = ps.executeQuery();
		// return rs;
		// while (rs.next()) {
		// int empno = Integer.parseInt(rs.getString(1));
		// String ename = rs.getString(2);
		// String job = rs.getString(3);
		// double sal = Double.parseDouble(rs.getString(5));
		// int dept = Integer.parseInt(rs.getString(4));
		// alist.add(new Employee(empno, ename, job, dept, sal));
		// }
		// return alist;
	}
}
