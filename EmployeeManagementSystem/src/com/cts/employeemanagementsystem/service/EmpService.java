package com.cts.employeemanagementsystem.service;

import com.cts.employeemanagementsystem.bean.Employee;

public interface EmpService {
	public String addEmployee(Employee employee);
	public String deleteEmployee(String id);
}
