package com.example.bike.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bike.entities.Bike;
import com.example.bike.services.BikeServices;
@RestController
@RequestMapping("/bike")
public class BikeController {
 
	BikeServices bkserv;

	public BikeController(BikeServices bkserv) {
		super();
		this.bkserv = bkserv;
	}
	@PostMapping
	public String createBike(@RequestBody Bike b) {
		 String msg= bkserv.createBike(b);
		 return msg;
	}
	@GetMapping
	public List<Bike> fetchAllBike(){
		List<Bike> lis=bkserv.fetchAllBike();
		return lis; 
	}
	@PutMapping
	public String updateBike(Bike b) {
		String msg=bkserv.updateBike(b);
		return msg;
	}
	@DeleteMapping
	public String deleteBike(String engNo) {
		String msg=bkserv.deleteBike(engNo);
		return msg;
	}
	
}
