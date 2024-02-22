package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;

public interface SongService {
	
	public String addSongs(Song song);
	public boolean songExists(String name);
	public List<Song> fetchsongs();
	public void updateSong(Song s);


}
