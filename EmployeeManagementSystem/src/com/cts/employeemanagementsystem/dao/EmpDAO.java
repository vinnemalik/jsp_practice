package com.cts.employeemanagementsystem.dao;

import com.cts.employeemanagementsystem.bean.Employee;

public interface EmpDAO {
	public String addEmployee(Employee employee);
	public String deleteEmployee(String id);
}
