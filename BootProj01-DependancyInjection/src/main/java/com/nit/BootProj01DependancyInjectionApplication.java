package com.nit;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nit.beans.WishMessageApp;

@SpringBootApplication
public class BootProj01DependancyInjectionApplication {

	//spring bean of calander class
	@Bean(name = "cal")
	public Calendar createCalendar() {
		return Calendar.getInstance();//return gregorian calander
	}

	public static void main(String[] args) {
		ApplicationContext acx=	SpringApplication.run(BootProj01DependancyInjectionApplication.class, args);
		
		//get wishMessage object
		WishMessageApp wmg=acx.getBean("wmg", WishMessageApp.class);
		
		//execute the b.logic
		System.out.println(wmg.wishMessageGenerator("Papu"));
		
		((ConfigurableApplicationContext) acx).close();
	}

}
