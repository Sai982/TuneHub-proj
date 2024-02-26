package com.example.bike.services;

import java.util.List;

import com.example.bike.entities.Bike;

public interface BikeServices {

	
	public String createBike( Bike b);
	
	public List<Bike> fetchAllBike();
	
	public String updateBike(Bike b);
	
	public String deleteBike(String engNo);
}
