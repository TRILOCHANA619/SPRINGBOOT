package com.nit.DAO;

import java.util.List;

import com.nit.model.Employee;

public interface InterfaceEmployeeDAO {

	public List<Employee> getEmployeeDAO(String desg1, String desg2, String desg3) throws Exception;
}
