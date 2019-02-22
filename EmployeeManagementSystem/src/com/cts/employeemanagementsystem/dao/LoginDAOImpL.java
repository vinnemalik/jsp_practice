package com.cts.employeemanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.employeemanagementsystem.util.DBUtils;

public class LoginDAOImpL implements LoginDAO {
	
	private static LoginDAOImpL loginDAOImpL;
	
	public static LoginDAOImpL getInstance()
	{
		if(loginDAOImpL == null)
		{
			 loginDAOImpL = new LoginDAOImpL();
			 return loginDAOImpL;
		}
		else
		{
			return loginDAOImpL;
		}
	}
	
	private LoginDAOImpL() {
		// TODO Auto-generated constructor stub
		
	}
	
	

	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		String query = "select userStatus from loginFinal where userId = ?";
		Connection connection = null;
		PreparedStatement preparedStatment = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, id); //1 stands for no of ? in query
			resultSet = preparedStatment.executeQuery();
			//query giving single record isliye if else while
			if(resultSet.next()){
				//refer initially before the first record
				return resultSet.getInt("userStatus"); //column name
				// agr 1 likha toh mtlb column sequence as per the select statement not from the table column 
				//Preferred is column name
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1; //if something went wrong exception aae and -1 aaya to i can know kuch glt hua h database m
	}

	public String getUserType(String id) {
		// TODO Auto-generated method stub
		String query = "select userType from loginFinal where userId = ?";
		Connection connection = null;
		PreparedStatement preparedStatment = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, id); //1 stands for no of ? in query
			resultSet = preparedStatment.executeQuery();
			//query giving single record isliye if else while
			if(resultSet.next()){
				//refer initially before the first record
				return resultSet.getString("userType"); //column name
				// agr 1 likha toh mtlb column sequence as per the select statement not from the table column 
				//Preferred is column name
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean authenticate(String userId, String password) {
		// TODO Auto-generated method stub
		String query = "select * from loginFinal where userId = ? AND password = ?";
		Connection connection = null;		
		PreparedStatement preparedStatment = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, userId); //1 stands for no of ? in query
			preparedStatment.setString(2, password);
			resultSet = preparedStatment.executeQuery();
			//query giving single record isliye if else while
			System.out.println("inside the authenticate");
			if(resultSet.next()){
				System.out.println("hello");
				return true; //true mtlb authenticated
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
}
