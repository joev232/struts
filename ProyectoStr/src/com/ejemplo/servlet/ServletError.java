package com.ejemplo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletError extends HttpServlet{
	
	private final Logger log=LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//coger los atributos de fallo a traves de request
		
		Integer codigoHTTP = (Integer) req.getAttribute("javax.servlet.error.status_code");  
		log.info("El error es he comentado xml :"+codigoHTTP);
		String nombreServlet = (String) req.getAttribute("javax.servlet.error.servlet_name"); 
		log.info("No hay servlet "+nombreServlet);
		
		resp.sendRedirect("paginaerror.html");
		//super.doGet(req, resp);
	}

}
