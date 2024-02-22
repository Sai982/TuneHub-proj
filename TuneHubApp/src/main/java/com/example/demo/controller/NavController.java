package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class NavController {

	

	@GetMapping("/map-register")
	public String registermappling() {
		return "register";
	}
	
	@GetMapping("/map-login")
	public String loginmappling() {
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String addSongs() {
			return "addsongs";
	}
	
	@GetMapping("/create")
	public String create() {
			return "samplepayement";
	}
}
