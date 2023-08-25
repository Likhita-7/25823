package com.pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LastBookSer")
public class LastBookSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pnr = 0;
		Connect cn = new Connect();
		try {
			con = cn.meth();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Ticket tt = (Ticket) request.getAttribute("ticket");
		ArrayList<Passenger> plist = tt.getTl();
		System.out.println(plist.size() + "sdfg");
		for (Passenger p : plist) {
			System.out.println(p.getName());
		}
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into traintable(tname,froms,tos,clas,date) values(?,?,?,?,?) returning pnr");
			ps.setString(1, tt.getTname());
			ps.setString(2, tt.getFrom());
			ps.setString(3, tt.getTo());
			ps.setString(4, tt.getClas());
			ps.setString(5, tt.getDate());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pnr = rs.getInt(1);
			}
			System.out.println(pnr);
			for (Passenger p : plist) {
				System.out.println(p.getAge());
				String query = "insert into passengertable values(?,?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(query);
				ps2.setInt(1, pnr);
				ps2.setString(2, p.getName());
				ps2.setInt(3, p.getAge());
				ps2.setString(4, p.getGender());
				int rs2 = ps2.executeUpdate();
				System.out.println(rs2);
				ps2.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
