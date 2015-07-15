package com.ejemplo.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ejemplo.connection.SessionManager;

public class ListenerServletContext implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		//estaria en un try 
		
//		
//		ServletContext sc=sce.getServletContext();
//		SessionFactory sf=(SessionFactory) sc.getAttribute("sf");
//		sf.close();
			
		//System.out.println("contexto destruido");
 }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//se llama cuando arranca la aplicacion 
		//session manager y log y iniciarHB
		
		//numero de peticiones
		//int n_petis=0;
		
		HttpSession session=null;
		ServletContext sc=null;
		//ya tengo contexto
		sc= sce.getServletContext();//refencia al objeto
		//llamar a session manager y coger el sessiomfactory y me guardo el contexto
		
		//SessionFactory sf= SessionManager.getSessionFactory();
		//sc.setAttribute("sf", sf);
		
		
		//lo añado al contexto mi mapa vacio
		Map<String, HttpSession> usuarioM=new HashMap<String, HttpSession>();
		//lo assigno el hasmap al sc
		sc.setAttribute("usuarioMap", usuarioM);
		
		System.out.println("contexto inicializado");
		
	}

}
