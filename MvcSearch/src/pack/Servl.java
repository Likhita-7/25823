package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servl")
public class Servl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String c = request.getParameter("c");
		String d = request.getParameter("d");
		String e = request.getParameter("e");
		String f = request.getParameter("f");

		String sql = "select * from rjpro where 1=1";
		if (a != null) {
			sql += " and empno=" + a;
		}
		if (b != null) {
			sql += " and ename=" + b;
		}
		if (c != null) {
			sql += " and job=" + c;
		}
		if (d != null) {
			sql += " and sal>=" + d;
		}
		if (e != null) {
			sql += " and sal=<" + e;
		}
		if (f != null) {
			sql += " and dept=" + f;
		}
		sql += ";";

		Clas obj = new Clas();
		try {
			Connection con = obj.meth1();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println(sql);
	}

}
