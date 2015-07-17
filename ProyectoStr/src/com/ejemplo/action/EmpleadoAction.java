package com.ejemplo.action;

import java.util.List;

import com.ejemplo.DAO.EmpHibernateDAO;
import com.ejemplo.service.EmployeeService;
import com.ejemplo.service.EmployeeServiceServlet;
import com.ejemplo.tablasDTO.Employees;
import com.opensymphony.xwork2.ActionSupport;

public class EmpleadoAction extends ActionSupport {
	
	private Employees empleado;
	private int employeeId;

	
	public Employees getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Employees empleado) {
		this.empleado = empleado;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
		
		
	EmployeeServiceServlet employeservice=new EmployeeServiceServlet();
	empleado=new Employees();
	empleado= (Employees) employeservice.leerEmpleado(employeeId);
		
	return SUCCESS;
}
}
