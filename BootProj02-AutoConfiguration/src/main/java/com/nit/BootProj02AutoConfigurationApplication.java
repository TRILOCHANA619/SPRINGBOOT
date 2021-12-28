package com.nit;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nit.DAO.EmployeeDAO;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootProj02AutoConfigurationApplication {



	@Bean
	public DataSource createDs() throws PropertyVetoException {
		ComboPooledDataSource cps=new ComboPooledDataSource();
		cps.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cps.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl"); cps.setUser("PAPU");
		cps.setPassword("papu");

		return cps;
	}


	public static void main(String[] args) {
		// IOC container
		ApplicationContext acx = SpringApplication.run(BootProj02AutoConfigurationApplication.class, args);

		// get the bean class object
		EmployeeDAO eDAO = acx.getBean("empDAO", EmployeeDAO.class);

		// execute the business logic
		try {

			int count = eDAO.getEmpCount();
			System.out.println("The No of employee is :: " + count);

		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) acx).close();

	}

}
