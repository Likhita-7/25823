package com.pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/jdbc")
public class jdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connect obj = new Connect();
	Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			con = obj.meth();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			JSONArray jslist = new JSONArray();
			Statement ps1 = con.createStatement();
			ResultSet rs1 = ps1.executeQuery("select distinct trn_start from train_data");
			while (rs1.next()) {
				JSONObject jo = new JSONObject();
				try {
					jo.put("from", rs1.getString(1));
				} catch (JSONException e) {
					e.printStackTrace();
				}
				jslist.put(jo);
			}
			response.getWriter().write(jslist.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
