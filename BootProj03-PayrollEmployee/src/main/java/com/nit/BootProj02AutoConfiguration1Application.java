package com.nit;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.PayRollEmployeeContrller;
import com.nit.model.Employee;

@SpringBootApplication
public class BootProj02AutoConfiguration1Application {

	public static void main(String[] args) {
		//create the IOC container
		ApplicationContext actx= SpringApplication.run(BootProj02AutoConfiguration1Application.class, args);
		
		//get the conttroller class object
		PayRollEmployeeContrller payrollempoyeecontroller=actx.getBean("empcontroller",PayRollEmployeeContrller.class);
		
		//execute the business logic
		try(Scanner scn= new Scanner(System.in)) {
			System.out.println("Enter the first designation :: ");
			String desg1=scn.nextLine().toUpperCase();
			System.out.println("Enter the Second designation :: ");
			String desg2=scn.nextLine().toUpperCase();
			System.out.println("Enter the Third designation :: ");
			String desg3=scn.nextLine().toUpperCase();
			List<Employee> empDetails= payrollempoyeecontroller.employeeDetailsController(desg1, desg2, desg3);
			
			//display the result
			System.out.println("Employee Details are");
			System.out.println("EmployeeID\tEmployee Name\tDesignation\tSalary");
			for (Employee employee : empDetails) {
				System.out.println(employee.getEmployeeID()+"\t\t"+employee.getEmployeeName()+"\t\t"+employee.getDesignation()+"\t\t"+employee.getSalary());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) actx).close();
	}

}
