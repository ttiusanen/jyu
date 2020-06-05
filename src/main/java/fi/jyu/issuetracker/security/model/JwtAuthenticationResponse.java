package fi.jyu.issuetracker.security.model;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL) 	
public class JwtAuthenticationResponse {

	private boolean success;
	private String token;
	private String message;

	public JwtAuthenticationResponse(String token, String message, boolean success) {
		this.token = token;
		this.message = message;
		this.success = success;
	}

	public String getToken() {
		if(null == token) {
			return null;
		}
		return "Bearer " + token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
