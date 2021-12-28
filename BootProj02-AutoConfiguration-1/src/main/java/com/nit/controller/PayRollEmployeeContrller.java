package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Employee;
import com.nit.service.EmployeeService;

@Controller("empcontroller")
public class PayRollEmployeeContrller {
	//has-a properties
	@Autowired
	private EmployeeService empServices;

	public List<Employee> employeeDetailsController(String desg1, String desg2, String desg3) throws Exception{
		
		//get the employee details
		List<Employee> employeeDetails=empServices.getEmployeeService(desg1, desg2, desg3);
		return employeeDetails;
		
	}
}
