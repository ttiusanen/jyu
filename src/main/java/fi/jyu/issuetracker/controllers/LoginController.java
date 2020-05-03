package fi.jyu.issuetracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.jyu.issuetracker.dao.models.UserDao;
import fi.jyu.issuetracker.dao.models.UserObj;
import fi.jyu.issuetracker.dao.repositories.UserRepository;
import fi.jyu.issuetracker.services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private UserRepository users;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/api/login")
	@CrossOrigin(origins = "http://localhost:3000")
	public String login(@RequestBody UserObj userObj) {
		if (loginService.handleLogin(userObj)) return "OK";
		
		return "Not authorized";
	}
	
	
	@PostMapping("/api/register")
	@CrossOrigin(origins = "http://localhost:3000")
	public String register(@RequestBody UserObj userObj) {
		UserDao newUser = new UserDao();
		newUser.setUsername(userObj.getUsername());
		// Hash password using Bcrypt (10 rounds)
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		newUser.setHash(encoder.encode(userObj.getPassword()));
		// Persist new user
		try {
			users.save(newUser);
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Registration failed";
	}
	
	@GetMapping("/api/users")
	public List<UserDao> users(){
		return users.findAll();
	}
}
