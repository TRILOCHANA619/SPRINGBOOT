package com.nit;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.controller.TouristPlaceController;
import com.nit.model.TouristPlace;

@SpringBootApplication
public class BootProj04DisplayToouristPlaceByGivenStateApplication {

	public static void main(String[] args) {
		
		//create IOCcontainer and getting the all necesssery data
	ApplicationContext actx=SpringApplication.run(BootProj04DisplayToouristPlaceByGivenStateApplication.class, args);
	
	//get the bean class
	TouristPlaceController touristPlaceController=actx.getBean("TouristPlaceController", TouristPlaceController.class);
	
	//get the details
	try(Scanner scn=new Scanner(System.in)){
		//getting the States from User
		System.out.println("Enter the First State ::");
		String state1=scn.nextLine().toLowerCase();
		System.out.println("Enter the Second State ::");
		String state2=scn.nextLine().toLowerCase();
		System.out.println("Enter the String State ::");
		String state3=scn.nextLine().toLowerCase();
		
		//getting the Tourist place list
		List<TouristPlace> tourPlaces= touristPlaceController.getTouristPlaceByStata(state1, state2, state3);
		
		//displaying the details
		//System.out.println("Tour Place\tPlace\tState");
		//tourPlaces.forEach(touristPlaces->{
		//	System.out.println(touristPlaces.getTouristPlace()+"\t"+touristPlaces.getPlace()+"\t"+touristPlaces.getState());
		//});
		System.out.println();
		System.out.println("Tourist Places of state "+state1+" , "+state2+" and "+state3+" are");
		tourPlaces.forEach(System.out::println);
		System.out.println();
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

}
