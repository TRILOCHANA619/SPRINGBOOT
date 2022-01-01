package com.nit.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.DAO.ITouristPlace;
import com.nit.DAO.TouristPlaceDAO;
import com.nit.model.TouristPlace;

@Service("TouristPlaceServices")
public class TouristPlaceService implements ITouristPlaceService {

	//has-a properties
	@Autowired
	private TouristPlaceDAO touristPlaceDAO;
	@Override
	public List<TouristPlace> getTouristPlaceService(String state1, String state2, String state3) throws Exception {
		//geting the torrist place list from DAO
		List<TouristPlace> touristPlaceList=touristPlaceDAO.getTouristPlace(state1, state2, state3);
		
		return touristPlaceList;
	}

}
