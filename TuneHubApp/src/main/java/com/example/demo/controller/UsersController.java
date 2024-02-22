 package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService users;
	@Autowired
	SongService ser;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
	{
		boolean userstatus=users.EmailExists(user.getEmail());
		if(userstatus==false) {
			users.addUser(user);
			return "registersucess";
		}
		else {
			
			return "registerfail";
		}
	}
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session) {
		boolean loginstatus = users.validateUser(email, password);
		if(loginstatus == true) {
			session.setAttribute("email", email);
			if(users.getRole(email).equals("admin")) {
				return "adminhome";
			}
			else {
				return "customerhome";
			}
			
		}
		else
		{
			return "loginfail ";
		}
		
		
	}
	@GetMapping("/exploresongs")
	public String exploreSongs(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		Users user= users.getUser(email);
		boolean userstatus=user.isPremium();
		if(userstatus==true) {
			 List<Song> li=ser.fetchsongs();
			 model.addAttribute("Songs", li);
			return"viewsongs";
		}
		else {
			return"makepayment";
		}
	}

}
