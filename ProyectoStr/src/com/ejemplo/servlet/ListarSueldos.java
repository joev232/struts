package com.ejemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.ejemplo.connection.Pool;
import com.ejemplo.connection.SessionManager;
import com.ejemplo.tablasDTO.Employees;

public class ListarSueldos extends HttpServlet {

	private final Logger log=LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/**
		 * aqui llamo al metodo
		 */
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		try{
		String sueldo= req.getParameter("sueldo");
		int sueldoe=Integer.parseInt(sueldo);
		
		Employees em=null;
		
		
		Session session=SessionManager.obtenerSesionNueva();
		List<Employees> sueldoemp=session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE SALARY<"+sueldoe).addEntity(Employees.class).list();
		Iterator it=sueldoemp.iterator();
		while(it.hasNext()){
			em=(Employees) it.next();
			
			pw.println("<h4>Nombre: "+ em.getFirstName()+" Salario: " +em.getSalary()+"</h4><br>");
		}
		}catch (NumberFormatException e){
			pw.println("El formato de sueldo no es correcto debe ser entero");
		}
	}
	
	/**
	 * 
	 * @param req
	 * @return metodo para comprobar si la peticion trae una cooki
	 */
	
	private Cookie existe(HttpServletRequest req,String nombre_cookie){
		//nombre_cookie puede ser en una clase constante
		Cookie cookieaux=null;
		Cookie cookie=null;
		
		Cookie[] array_cookies=req.getCookies();
		boolean encontrada=false;
		int pos=0;
		
		if(array_cookies != null){
			
				while((pos<array_cookies.length)&&(!encontrada))
				{
					cookieaux=array_cookies[pos];
					if(cookieaux.getName().equals(nombre_cookie)){
						encontrada=true;
						cookie=cookieaux;
					}else{
						pos=pos+1;
					}
				}
				if(!encontrada){
					cookie=new Cookie("nombre_cookie", "0");
					log.info("Ele nombre de la cookie"+cookie);
				}
//				for(int i=0;i<array_cookies.length;i++){
//				cookieaux=array_cookies[i];
//				log.trace("Nombre cookie i"+cookieaux.getName());
//				if(array_cookies[i].getName().equals("nombre_cookie")){
//					
//					cookieaux=array_cookies[i];
//					//String identificador = cookieaux.getName();
//					//String valor = cookieaux.getValue();
//					log.trace("valor");
//				}
//				}
		}else{
			cookieaux = new Cookie("nombre_cookie", "0");
			
		}
	//	Cookie miCookie = new Cookie(“idCliente”,”dato”);
		return cookie;
	}
	
}
