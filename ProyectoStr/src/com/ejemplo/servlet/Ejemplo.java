package com.ejemplo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.ejemplo.connection.Pool;


import com.ejemplo.tablasDTO.Empleado;



public class Ejemplo extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre=req.getParameter("nombre");
		//int id_empleado=Integer.parseInt(nombre);
		
		
		PrintWriter salida=resp.getWriter();
		//salida.println("Ingrese su ID");
		try {
			Connection conn=null;
			ResultSet rset=null;
			Statement stmt=null;
			
			String name=null;
			
			conn=Pool.getConnection();	
			stmt= conn.createStatement();
			//rset = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID="+id_empleado);
			
			rset=stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID="+nombre);
			Empleado empleado=null;
			
			if (rset.next()){
					//Empleado 
					//0name=empleado.getFirst_name();
					name = rset.getString(2);
			}else{
				name="No hay empleado";
				
			}
			//salida.println();
			resp.setContentType("text/html");
			salida.println(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=100
	}
	
}
