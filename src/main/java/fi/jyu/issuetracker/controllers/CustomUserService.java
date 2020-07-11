package fi.jyu.issuetracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.jyu.issuetracker.dao.repositories.UserRepository;
import fi.jyu.issuetracker.security.model.User;

@RestController
public class CustomUserService {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/api/users")
	public List<User> users(){
		return userRepository.findAll();
	}  
    
}