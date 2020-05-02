package fi.jyu.issuetracker.dao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "description")
	private String description;
	
    @Enumerated(EnumType.STRING)
    private Severity severity;
    
    @Enumerated(EnumType.STRING)
    private Status status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Severity getSeverity() {
		return severity;
	}
	
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
