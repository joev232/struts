package com.ejemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ejemplo.connection.Pool;
import com.ejemplo.tablasDTO.Empleado;

public class ServletAutenticacion extends HttpServlet{
	
private final Logger log= LogManager.getRootLogger();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String nombre=req.getParameter("nombre");
		String pass=req.getParameter("pass");
		
		//desarrollo de una cookie
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		try {
			Connection conn=null;
			ResultSet rset=null;
			Statement stmt=null;
			ServletContext sc=null;
			HttpSession session=null;
			
			conn=Pool.getConnection();	
			stmt= conn.createStatement();
			
			rset=stmt.executeQuery("SELECT * FROM USUARIO WHERE USER_NAME='"+nombre+"'and USER_PASS='"+pass+"'");
			//rset=stmt.executeQuery("select * from USUARIO WHERE USER_NAME="+nombre);
			if (rset.next()){
				String nombreusuario=rset.getString(1);
				String password=rset.getString(2);
				
				if((nombreusuario.equals(nombre)) && (password.equals(pass))   ){
					log.info("Bienvenido"+nombreusuario);
					session=req.getSession();
					session.setAttribute("nombreusuario", nombreusuario);
					//hago el logout
					
					//sc.setAttribute(nombreusuario, password);
				}
				/**
				 * else{
					log.info("usuario no existe");
					pw.println("usuario no existe");
				}
				 */
				pw.println("Bienvenido  "+nombreusuario);
				//pw.println(edto.getFirstName());
				pw.println("<ul>");
				pw.println("<li>");
				pw.println("<a href=\"/ProyectoWeb/ingresarsalario.html\"> Listar Sueldos </a>" );
				pw.println("</li>");
				pw.println("</ul>");
				//pw.println("<form >");
				pw.println("<ul>");
				pw.println("<li>");
				pw.println("<a href=\"/ProyectoWeb/ListaDepartamento\"> Lista Departamentos </a>" );
				pw.println("</li>");
				pw.println("</ul>");
			
				pw.println("<ul>");
				pw.println("<li>");
				pw.println("<a href=\"/ProyectoWeb/CerrarSession\"> SALIR </a>" );
				pw.println("</li>");
				pw.println("</ul>");

				
			} else{
				log.info("usuario no existe");
				pw.println("usuario no existe");
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//pool.liberarRecursos(conn, stm, rset);
		}
		
	//	super.doPost(req, resp);
	}
	
}
