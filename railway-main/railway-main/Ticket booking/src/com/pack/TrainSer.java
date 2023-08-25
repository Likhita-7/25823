package com.pack;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/TrainSer")
public class TrainSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connect obj = new Connect();
	Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("par1");
		String to = request.getParameter("par2");
		try {
			con = obj.meth();
			PreparedStatement st = con
					.prepareStatement("select trn_name from train_data where trn_start=? and trn_end=?");
			st.setString(1, from);
			st.setString(2, to);
			ResultSet rs = st.executeQuery();
			JSONArray js = new JSONArray();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				try {
					jo.put("train", rs.getString(1));
				} catch (JSONException e) {
					e.printStackTrace();
				}
				// System.out.println(js.toString());
				js.put(jo);
			}
			response.getWriter().write(js.toString());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
