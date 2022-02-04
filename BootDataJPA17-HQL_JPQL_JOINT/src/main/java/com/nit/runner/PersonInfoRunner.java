package com.nit.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Person;
import com.nit.entity.PersonPhoneNo;
import com.nit.service.IPersonInfoService;


@Component("personRunner")
public class PersonInfoRunner implements CommandLineRunner {

	@Autowired
	private IPersonInfoService service;

	@Override
	public void run(String... args) throws Exception {


		service.fechDataByJoin().forEach(row->{
			for (Object val : row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});

	}

}
