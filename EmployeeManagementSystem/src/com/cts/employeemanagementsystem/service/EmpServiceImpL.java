package com.cts.employeemanagementsystem.service;

import com.cts.employeemanagementsystem.bean.Employee;
import com.cts.employeemanagementsystem.dao.EmpDAO;
import com.cts.employeemanagementsystem.dao.EmpDAOImpL;

public class EmpServiceImpL implements EmpService {

	
	EmpDAO empdao = new EmpDAOImpL();
	
		
		public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empdao.addEmployee(employee);
	}

	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		return empdao.deleteEmployee(id);
	}
	
}
