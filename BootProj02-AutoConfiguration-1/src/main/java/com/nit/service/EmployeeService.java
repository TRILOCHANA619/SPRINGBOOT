package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.DAO.EmployeeDAO;
import com.nit.model.Employee;

@Service("empservices")
public class EmployeeService implements InterfaceEmployeeService {

	//has-a properties
	@Autowired
	private EmployeeDAO empdao;
	@Override
	public List<Employee> getEmployeeService(String desg1, String desg2, String desg3) throws Exception {
		
		//call the employeeDAO class emloyee method
		List<Employee> empdeails= empdao.getEmployeeDAO(desg1, desg2, desg3);
		
		return empdeails;
	}

}
