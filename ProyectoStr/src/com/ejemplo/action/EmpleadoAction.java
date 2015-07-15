package com.ejemplo.action;

import java.util.List;

import com.ejemplo.service.EmployeeService;
import com.ejemplo.service.EmployeeServiceServlet;
import com.ejemplo.tablasDTO.Employees;
import com.opensymphony.xwork2.ActionSupport;

public class EmpleadoAction extends ActionSupport {
	
	Employees empleado;
	int id;

	public Employees getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employees empleado) {
		this.empleado = empleado;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
		
	EmployeeServiceServlet employeservice=new EmployeeServiceServlet();
	
		
	
	 empleado= (Employees) employeservice.leerEmpleado(id);
		
	return SUCCESS;
}
}
