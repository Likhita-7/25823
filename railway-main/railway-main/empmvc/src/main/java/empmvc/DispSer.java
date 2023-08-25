package empmvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispSer")
public class DispSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jdbcmvcemp j=new Jdbcmvcemp();
		ArrayList<Employee> alist=j.getAll();
		request.setAttribute("jlist",alist);
		
		RequestDispatcher rd=request.getRequestDispatcher("/Last.jsp");
		rd.forward(request,response);
	}

}
