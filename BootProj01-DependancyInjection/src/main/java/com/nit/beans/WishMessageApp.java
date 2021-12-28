package com.nit.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageApp {

	
	//has a property
	@Autowired
	private Calendar calander;
	
	//b.logic
	public String wishMessageGenerator(String user) {
		//get hour
		int hour=calander.get(Calendar.HOUR_OF_DAY);
		
		//generate wishMessage
		if (hour<12) {
			return "Good Morning :: "+user;
		} else if (hour<16) {
			return "Good AfterNoon :: "+user;
		}else if (hour<20) {
			return "Good Evening :: "+user;
		}else {
			return "Good Night :: "+user;
		}
	}
	
}
