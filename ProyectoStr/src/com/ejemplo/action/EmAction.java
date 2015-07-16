package com.ejemplo.action;

import com.ejemplo.tablasDTO.Emp;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

public class EmAction extends ActionSupport {
	
	
	private Emp emp;



	public Emp getEmp() {
		return emp;
	}


    @TypeConversion(converter="com.ejemplo.action.ConversorPersona")
	public void setEmp(Emp emp) {
		this.emp = emp;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		
		
		return SUCCESS;
	}

}
