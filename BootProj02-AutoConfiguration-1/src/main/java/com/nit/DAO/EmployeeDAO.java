package com.nit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("empdao")
public class EmployeeDAO implements InterfaceEmployeeDAO{
	
	@Autowired
	private DataSource ds;

	//query
	private static final String SELECT_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMPLOYEE WHERE JOB IN(?,?,?) ";
	
	@Override
	public List<Employee> getEmployeeDAO(String desg1,String desg2,String desg3) throws Exception {
		
		//get the list object
		List<Employee> employeelist=new ArrayList<Employee>();
		
		
		//create the connection object
		Connection con=ds.getConnection();
		
		//create the prepared staatement object
		PreparedStatement ps=con.prepareStatement("SELECT EID,ENAME,DESG,SALARY FROM EMPLOYEE5 WHERE DESG IN (?,?,?)");
		
		//set the parameter
		ps.setString(1, desg1);
		ps.setString(2, desg2);
		ps.setString(3, desg3);
		
		//execute the query
		ResultSet rs=ps.executeQuery();
		
		if (rs!=null) {
			while (rs.next()) {
				Employee emp=new Employee();
				System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getFloat(4));
				emp.setEmployeeID(rs.getInt(1));
				emp.setEmployeeName(rs.getString(2));
				emp.setDesignation(rs.getString(3));
				emp.setSalary(rs.getFloat(4));
				
				//add to list
				employeelist.add(emp);
			}
			System.out.println(employeelist);
		}
		return employeelist;
	}

	
}
