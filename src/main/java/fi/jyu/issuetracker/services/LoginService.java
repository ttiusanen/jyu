package fi.jyu.issuetracker.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fi.jyu.issuetracker.dao.models.UserDao;
import fi.jyu.issuetracker.dao.models.UserObj;
import fi.jyu.issuetracker.dao.repositories.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository users;
	
	public boolean handleLogin(UserObj user) {
		
		String login = user.getUsername();
		System.out.println(login);
		Optional<UserDao> existingUser = users.findByUsername(login);
		if (!existingUser.isPresent()) return false;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (encoder.matches(user.getPassword(), existingUser.get().getHash())) return true;
		
		return false;
	}

}
