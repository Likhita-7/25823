package com.pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookSer")
public class BookSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String tlist = request.getParameter("tlist");
		String clas = request.getParameter("clas");
		String dat = request.getParameter("dat");
		String[] name = request.getParameterValues("Name");
		String[] age = request.getParameterValues("Age");
		String[] gender = request.getParameterValues("Gender");
		// System.out.println(name[1] + " " + age[1] + " " + gender[1]);
		Connect cn = new Connect();
		Ticket tt = cn.meth3(tlist, from, to, clas, dat, name, age, gender);
		System.out.println(tt.getTname());
		request.setAttribute("ticket", tt);
		//
		request.getRequestDispatcher("/Preview.jsp").include(request, response);
		// request.getRequestDispatcher("/LastBookSer").include(request, response);
	}

}
