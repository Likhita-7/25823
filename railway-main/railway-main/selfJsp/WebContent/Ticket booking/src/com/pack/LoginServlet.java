package com.pack;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultSet rs = null;
		Validations obj = new Validations();
		String[] nam = new String[5];
		String[] pas = new String[5];
		int i = 0;
		String name = request.getParameter("par1");
		String pass = request.getParameter("par2");

		try {
			rs = obj.connect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				nam[i] = rs.getString(1);
				pas[i] = rs.getString(2);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int flag = 0;
		for (int j = 0; j < i; j++) {
			if (name.equals(nam[j]) && pass.equals(pas[j])) {
				System.out.println("valid");
				flag++;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("invalid");
			request.getRequestDispatcher("Loginpage.html").forward(request, response);
		} else {
			response.sendRedirect("HomePage.jsp");
			String key = "123";
			request.getSession().setAttribute("myData", key);
		}
	}

}
