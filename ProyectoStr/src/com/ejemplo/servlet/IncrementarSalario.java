package com.ejemplo.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncrementarSalario extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println(getServletContext().getInitParameter("username"));

		ServletConfig conf=getServletConfig();
		String s2=conf.getInitParameter("n2");
		System.out.println(s2);
		
		
		/**
 * ServletConfig conf=getServletConfig();
     String s2=conf.getInitParameter("n2");

 */

	//	super.doGet(req, resp);
	}
	

}
