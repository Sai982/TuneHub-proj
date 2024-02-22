package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	 SongService ser;
	@PostMapping("/addsong")
	public String addSongs(@ModelAttribute Song song) {
		boolean songstatus=ser.songExists(song.getName());
		if(songstatus==false) {
			ser.addSongs(song);
			return"addsongsucess";
		}
		else {
			return"addsongfail";
		}
		
	}
	@GetMapping("/fetchsongs")
	public String fetchsongs(Model model){
		
		 List<Song> li=ser.fetchsongs();
		 model.addAttribute("Songs", li);
		
		return"viewsongs";
	}

	@GetMapping("/usersongs")
	public String viewSongs(Model model) {
		
		 List<Song> li=ser.fetchsongs();
		 model.addAttribute("Songs", li);
		boolean primestatus=true;
		if(primestatus==true) {
			return"userviewsongs";
		}
		else
	    {
			return"makepayment";
	    }
	}
}
