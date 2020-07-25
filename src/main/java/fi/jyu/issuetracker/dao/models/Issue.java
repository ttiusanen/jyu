package fi.jyu.issuetracker.dao.models;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import fi.jyu.issuetracker.security.model.User;

/**
 * Class Issue represents user created issues. Includes JPA entity information.
 * Validates fields before persisting.
 */
@Entity
@Table(name = "Issue")
public class Issue implements Serializable {
	
	/**
	 * Auto generated serialVersionUID
	 */
	private static final long serialVersionUID = -7975098490590780899L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Long id;
	
	@NotNull
    @NotEmpty
	@Column(name = "summary")
	private String summary;
	
	@NotNull
    @NotEmpty
	@Column(name = "description")
	private String description;
	
    @Enumerated(EnumType.STRING)
    private Importance importance;
	
    @Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	// Returns user if user has been initialized. Otherwise returns null.
	public Optional<User> getUser(){
		return Optional.ofNullable(user);
	}

	/*
	  Generic setters and getters
	*/

	public void setUser(User user){
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSummary(){
		return this.summary;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Importance getImportance() {
		return importance;
	}
	
	public void setImportance(Importance importance) {
		this.importance = importance;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
