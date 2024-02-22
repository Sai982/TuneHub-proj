package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

@Controller
public class PlaylistController {
	 @Autowired
     PlaylistService playser;
     @Autowired
     SongService sonser;
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		
		 List<Song> list=sonser.fetchsongs();
		 model.addAttribute("Songslist", list);
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		
		boolean status=playser.palylistExists(playlist.getName());
		
		if(status==false) {
			playser.addPlaylist(playlist);
			List<Song> list= playlist.getSong(); 
			for(Song s : list) {
				s.getPlaylist().add(playlist);
				sonser.updateSong(s);
			}
			return"playlistsucess";
		}
		else {
			return"playlistfail";
		}
				
	}
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		
		List<Playlist> li=playser.viewPlaylist();
		
		model.addAttribute("playlist", li);
		
		return "viewplaylist";
	}
}
