package com.example.bike.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bike.entities.Bike;
import com.example.bike.repositories.BikeRepositories;
@Service
public class BikeServiceImplementation implements BikeServices
{ 
	BikeRepositories bkrapo;
	
	public BikeServiceImplementation(BikeRepositories bkrapo) {
		super();
		this.bkrapo = bkrapo;
	}
     @Override
	public String createBike(Bike b) {
		bkrapo.save(b);
		return "Bike object is created and saved ";
	}
	@Override
	public List<Bike> fetchAllBike() {
		List<Bike>li=bkrapo.findAll();
		return li;
	}
	@Override
	public String updateBike(Bike b) {
		bkrapo.save(b);
		return "Bike object is updated";
	}
	@Override
	public String deleteBike(String engNo) {
		bkrapo.deleteById(engNo);
		return "Bike object is deleted";
	}

}
