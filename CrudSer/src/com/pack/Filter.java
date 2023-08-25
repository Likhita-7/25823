package com.pack;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpFilter;

@WebFilter("/MainSer")
public class Filter extends HttpFilter {

	public Filter() {
	}

	public void destroy() {
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code heres
		String seskey = "" + request.getAttribute("sesvar");
		String headkey = (String) request.getHeader("head");

		System.out.println(seskey + " " + headkey);
		if (seskey.equals(headkey)) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("LoginPage.html").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
