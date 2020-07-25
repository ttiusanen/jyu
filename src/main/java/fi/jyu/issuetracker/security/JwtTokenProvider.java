package fi.jyu.issuetracker.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JwtTokenProvider provides functionalities for creating and validating JWT tokens.
 */
@Component
public class JwtTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${credentials.jwtSecret}")
	private String jwtSecret;

	@Value("${credentials.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	/**
	 * Generates JWT token from Spring Security Authentication object.
	 * @param authentication user authentication details.
	 * @return JWT token
	 */
	public String generateToken(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	/**
	 * Returns username from JWT token.
	 * @param token JWT token.
	 * @return username
	 */
	public String getUserNameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	/**
	 * Validates JWT token against authorization token.
	 * @param authToken
	 * @return true if token is valid. False otherwise.
	 */
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			logger.debug("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			logger.debug("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			logger.debug("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			logger.debug("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			logger.debug("JWT claims string is empty.");
		}
		return false;
	}
}