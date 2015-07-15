package com.ejemplo.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ListenerHttp implements HttpSessionListener{

	private final Logger log= LogManager.getRootLogger();
	
	//private final Logger log= LogManager.getRootLogger();
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
		//agrego la session  
		ServletContext sc=null;
		//HttpSession session=arg0.getSession();
		
		HttpSession session= arg0.getSession();
		sc=session.getServletContext();
		
		//hacer un casting a map
		HashMap<String, HttpSession> map= (HashMap<String, HttpSession>) sc.getAttribute("usuarioMap");
		map.put(session.getId(), session);
		
		System.out.println("session creado");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		HttpSession session=arg0.getSession();
		String id=session.getId();
		HashMap<String, HttpSession> map= (HashMap<String, HttpSession>) session.getServletContext().getAttribute("usuarioMap");
		map.remove(id);
		
		//Cuando llaman a invalidate desde listener
		//System.out.println("Session Destruido");
		
	}

}
