package fi.jyu.issuetracker.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fi.jyu.issuetracker.dao.models.UserDao;
import fi.jyu.issuetracker.dao.models.UserWithToken;
import fi.jyu.issuetracker.dao.models.LoginObj;
import fi.jyu.issuetracker.dao.repositories.UserRepository;

// poistettu pomista security starter, lisäsi kaikkea mielenkiintoista projektiin...

@Service
public class LoginService {
	
	@Autowired
	private UserRepository users;
	
	@Autowired
	private JwtTokenUtil tokenService;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public UserWithToken handleLogin(LoginObj login) {
		// pura tarkistus ja token erikseen
		try {
			System.out.println("Loginissa");
			UserDao user = getUser(login);
			if (validatePassword(login, user)) {
				String token = generateToken(user);
				UserWithToken loggedUser = new UserWithToken(user.getId(), user.getUsername(), token);
				return loggedUser;
			}
			return null;
		} catch (Exception e) {
			//
		}
				
		return null;
	}
	
	public UserDao getUser(LoginObj userObj) {
		try {
			String login = userObj.getUsername();
			Optional<UserDao> existingUser = users.findByUsername(login);
			return existingUser.get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public boolean validatePassword(LoginObj login, UserDao user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(login.getPassword(), user.getHash());
	}
	
	private String generateToken(UserDao user) {
		return tokenService.generateToken(user);	
	}

}
