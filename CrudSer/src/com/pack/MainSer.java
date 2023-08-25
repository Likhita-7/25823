package com.pack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/MainSer")
public class MainSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Employee> alist = null;
	int pos = -1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("html");
		Connect conn = new Connect();
		JSONObject obj = new JSONObject();
		try {
			alist = conn.meth1();
			System.out.println(alist);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String com = request.getParameter("par");
		if (com.equals("first")) {
			pos = 0;
			Employee e = alist.get(pos);
			try {
				obj.put("empno", e.getEmpno());
				obj.put("ename", e.getName());
				obj.put("job", e.getJob());
				obj.put("sal", e.getSal());
				obj.put("dept", e.getDept());
				response.getWriter().println(obj.toString());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		if (com.equals("last")) {
			pos = alist.size() - 1;
			Employee e = alist.get(pos);
			try {
				obj.put("empno", e.getEmpno());
				obj.put("ename", e.getName());
				obj.put("job", e.getJob());
				obj.put("sal", e.getSal());
				obj.put("dept", e.getDept());
				response.getWriter().println(obj.toString());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		if (com.equals("next")) {
			pos = (pos + 1) % alist.size();
			Employee e = alist.get(pos);
			try {
				obj.put("empno", e.getEmpno());
				obj.put("ename", e.getName());
				obj.put("job", e.getJob());
				obj.put("sal", e.getSal());
				obj.put("dept", e.getDept());
				response.getWriter().println(obj.toString());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		if (com.equals("prev")) {
			pos--;
			if (pos < 0)
				pos = alist.size() - 1;

			Employee e = alist.get(pos);
			try {
				obj.put("empno", e.getEmpno());
				obj.put("ename", e.getName());
				obj.put("job", e.getJob());
				obj.put("sal", e.getSal());
				obj.put("dept", e.getDept());
				response.getWriter().println(obj.toString());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		if (com.equals("delete")) {
			int ser = Integer.parseInt(request.getParameter("par3"));
			for (Employee ex : alist) {
				if (ex.getEmpno() == ser) {
					alist.remove(ex);
					try {
						conn.meth4(ser);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		if (com.equals("search")) {
			int ser = Integer.parseInt(request.getParameter("par3"));
			System.out.println(ser);
			for (Employee ex : alist) {
				if (ex.getEmpno() == ser) {
					System.out.println(ex.getEmpno() + " " + ser);
					try {
						obj.put("empno", ex.getEmpno());
						obj.put("ename", ex.getName());
						obj.put("job", ex.getJob());
						obj.put("sal", ex.getSal());
						obj.put("dept", ex.getDept());
						System.out.println(obj);
						response.getWriter().println(obj.toString());
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
					break;
				}
			}
		}
		if (com.equals("save")) {
			int a = Integer.parseInt(request.getParameter("empno"));
			String b = request.getParameter("ename");
			String c = request.getParameter("job");
			double d = Double.parseDouble(request.getParameter("sal"));
			int e = Integer.parseInt(request.getParameter("dept"));
			String nex = request.getParameter("par2");
			if (nex.equals("add")) {
				try {
					int conf = conn.meth2(a, b, c, d, e);
					if (conf == 1)
						alist.add(new Employee(a, b, c, e, d));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (nex.equals("edit")) {
				try {
					int conf1 = conn.meth3(a, b, c, d, e);
					if (conf1 == 1) {
						for (Employee ex : alist) {
							if (ex.getEmpno() == a)
								alist.remove(ex);
							break;
						}
						alist.add(new Employee(a, b, c, e, d));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}
	}

}
