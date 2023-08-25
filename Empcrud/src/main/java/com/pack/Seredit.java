package com.pack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

@WebServlet("/Seredit")
public class Seredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  Functional fun;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		fun = new Functional();
		try {
			fun.conn();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		int v1=Integer.parseInt(request.getParameter("par1"));
		String v2=request.getParameter("par2");
		String v3=request.getParameter("par3");
		double v4=Double.parseDouble(request.getParameter("par4"));
		int v5=Integer.parseInt(request.getParameter("par5"));
		try {
			JSONArray var1=fun.meth3(v1, v2, v3, v5, v4);
			System.out.println(var1);
			response.getWriter().write(var1.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
}