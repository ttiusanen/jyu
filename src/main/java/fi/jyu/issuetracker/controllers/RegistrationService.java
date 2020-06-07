package fi.jyu.issuetracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fi.jyu.issuetracker.dao.repositories.UserRepository;
import fi.jyu.issuetracker.security.model.User;

/*
Controller / Service class for handling user registration.
*/
@RestController
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Creates a new user. Validates that username and password are not empty 
    // and email is well formed.
    @PostMapping("/api/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void register(@Valid @RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
    
}