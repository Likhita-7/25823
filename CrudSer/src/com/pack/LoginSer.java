package com.pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSer
 */
@WebServlet("/LoginSer")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResultSet connect() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
				"plf_training_admin", "pff123");
		PreparedStatement ps = con.prepareStatement("select * from validation");
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	String[] nam = new String[5];
	String[] pas = new String[5];

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ss = request.getSession();
		int i = 0;
		String name = request.getParameter("par1");
		String pass = request.getParameter("par2");
		System.out.println(name + "" + pass);
		try {
			ResultSet rss = connect();
			while (rss.next()) {
				nam[i] = rss.getString(1);
				pas[i] = rss.getString(2);
				i++;

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		int flag = 0;
		for (int j = 0; j < i; j++) {
			if (name.equals(nam[j]) && pass.equals(pas[j])) {
				ss.setAttribute("sesvar", "456");
				response.setHeader("headvar", "456");
				System.out.println("valid");
				flag++;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("invalid");
			request.getRequestDispatcher("LoginPage.html").forward(request, response);
		}
		request.getRequestDispatcher("HomePage.jsp").forward(request, response);
	}

}
