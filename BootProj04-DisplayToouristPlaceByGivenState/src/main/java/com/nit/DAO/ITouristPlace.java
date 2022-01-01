package com.nit.DAO;

import java.util.List;

import com.nit.model.TouristPlace;

public interface ITouristPlace {

	public List<TouristPlace> getTouristPlace(String state1,String state2,String state3) throws Exception;
}
