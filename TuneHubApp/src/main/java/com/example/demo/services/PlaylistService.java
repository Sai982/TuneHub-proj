package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Playlist;

public interface PlaylistService {
	
	public String addPlaylist(Playlist playlist);
	public boolean palylistExists(String name);
	public List<Playlist> viewPlaylist();

}
