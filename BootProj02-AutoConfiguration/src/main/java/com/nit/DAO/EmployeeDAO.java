package com.nit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDAO")
public class EmployeeDAO {

	private static final String QUERY="SELECT COUNT(*) FROM EMPLOYEE";
	
	//has-aproperty
	@Autowired
	private DataSource ds;

	//b.logic
	public int getEmpCount() throws Exception{
		System.out.println("EmployeeDAO.getEmpCount()");
		System.out.println("Injected Database name is :: "+ds.getClass());
		
		//get pooled connection Object
		Connection con=ds.getConnection();
		
		//get prepared statement object
		PreparedStatement ps=con.prepareStatement(QUERY);
		
		//Execue the query
		
		ResultSet rs=ps.executeQuery();
		
		rs.next();
		
		//get result 
		int count=rs.getInt(1);
		
		//close the object
		rs.close();
		ps.close();
		con.close();
		
		return count;
	}
}
