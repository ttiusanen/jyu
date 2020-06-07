package fi.jyu.issuetracker.security.model;

/*
Class representing user role. Needed for Spring Security user handling.
*/
public class Role {

	private RoleName roleName;

	public Role() {
		// All roles are ADMIN roles. 
		this.roleName = RoleName.ADMIN;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

}
