
package fi.jyu.issuetracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import fi.jyu.issuetracker.security.JwtTokenProvider;
import fi.jyu.issuetracker.security.model.JwtAuthenticationResponse;
import fi.jyu.issuetracker.security.model.User;

/**
 * Bean handles user authentication with username and password.
 */
@Service
public class AuthenticationBean {

	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthenticationBean() {

	}

	public AuthenticationBean(JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager) {
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
	}

	/**
	 * Authenticates user and returns jwt token
	 * 
	 * @param user
	 * @return
	 */
	public Object authenticateUser(User user) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new JwtAuthenticationResponse(tokenProvider.generateToken(authentication), null, true);	
		} catch (Exception e) {
			return new JwtAuthenticationResponse(null, e.getMessage(), false);
		}
	}

}