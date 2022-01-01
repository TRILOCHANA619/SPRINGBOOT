package com.nit.service;

import java.util.List;

import com.nit.model.TouristPlace;

public interface ITouristPlaceService {

	public List<TouristPlace> getTouristPlaceService(String state1,String state2,String state3) throws Exception;
}
