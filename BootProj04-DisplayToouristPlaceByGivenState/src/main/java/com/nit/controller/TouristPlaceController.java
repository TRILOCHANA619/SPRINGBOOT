package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.TouristPlace;
import com.nit.service.TouristPlaceService;

@Controller("TouristPlaceController")
public class TouristPlaceController {
	
	//Has-a properties
	@Autowired
	private TouristPlaceService touristPlaceService;
	
	//method for getting the tourist list
	public List<TouristPlace> getTouristPlaceByStata(String state1,String state2,String state3) throws Exception{
		
		//getting the list from the service class
		List<TouristPlace> touristPlaces=touristPlaceService.getTouristPlaceService(state1, state2, state3);
		
		return touristPlaces;
	}
	
}
