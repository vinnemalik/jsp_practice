package com.cts.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.employeemanagementsystem.bean.Employee;
import com.cts.employeemanagementsystem.util.DBUtils;

public class EmpDAOImpL implements EmpDAO {

	
	private static EmpDAOImpL empDAOImpL;
	
	public static EmpDAOImpL getInstance()
	{
		if(empDAOImpL == null)
		{
			 empDAOImpL = new EmpDAOImpL();
			 return empDAOImpL;
		}
		else
		{
			return empDAOImpL;
		}
	}
	
	private EmpDAOImpL() {
		// TODO Auto-generated constructor stub
		
	}
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String query = "insert into employee(empId,empFirstName,empLastName,salary)" + "values(?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatment = null;
		//ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, id); //1 stands for no of ? in query
			resultSet = preparedStatment.executeQuery();
			//query giving single record isliye if else while
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		            
	}

	

	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
