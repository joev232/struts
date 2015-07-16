package com.ejemplo.action;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.ejemplo.tablasDTO.Emp;
import com.ejemplo.tablasDTO.Empleado;

public class ConversorPersona extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		
		Emp emp = new Emp(arg1[0],arg1[1]);
		return emp;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		Emp e = (Emp)arg1;
		
		return e.toString();
	}

	
	
}
