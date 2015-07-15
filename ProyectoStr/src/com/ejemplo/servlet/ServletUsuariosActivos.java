package com.ejemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletUsuariosActivos extends HttpServlet{

	
	private final Logger log=LogManager.getRootLogger();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		ServletContext sc=getServletContext();
		//HashMap<K, V>
		HashMap map=(HashMap) sc.getAttribute("usuarioMap");
		
		//entry clave valor
		Iterator it=map.entrySet().iterator();
		Map.Entry e=null;
		
		PrintWriter pw= resp.getWriter();
		while(it.hasNext()){
			e=(Entry) it.next();
			log.info(e.getKey());
			log.info(e.getValue());
			pw.println(e.getKey());
			pw.println(e.getValue());
		}
		
	//	super.doGet(req, resp);
	}
}
