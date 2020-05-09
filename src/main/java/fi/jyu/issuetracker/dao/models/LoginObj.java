package fi.jyu.issuetracker.dao.models;

/**
 * Class handling user login data
 * @author ttius
 *
 */
public class LoginObj{
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
