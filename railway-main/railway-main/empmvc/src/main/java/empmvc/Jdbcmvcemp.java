package empmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jdbcmvcemp {

	public ArrayList<Employee> getAll() {
		
		ArrayList<Employee> elist = new ArrayList<>();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"1810");
			// out.println("class found");
			PreparedStatement ps = con.prepareStatement("select * from rjproj");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int a = Integer.parseInt(rs.getString("empno"));
				String b = rs.getString("ename");
				String c = rs.getString("job");
				double d = Double.parseDouble(rs.getString("sal"));
				int e = Integer.parseInt(rs.getString("dept"));

				elist.add(new Employee(a, e, c, b, d));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elist;
	}
	public static void main(String[] args) {
		Jdbcmvcemp obj=new Jdbcmvcemp();
		System.out.println(obj.getAll());
	}

}
