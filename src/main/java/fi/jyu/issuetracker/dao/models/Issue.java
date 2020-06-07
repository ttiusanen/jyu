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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Issue")
public class Issue implements Serializable {
	
	/**
	 * Auto generated serialVersionUID
	 * 
	 * TODO: validation for ENUMs
	 */
	private static final long serialVersionUID = -7975098490590780899L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@NotNull
    @NotEmpty
	@Column(name = "description")
	private String description;
	
    @Enumerated(EnumType.STRING)
    private Importance importance;
	
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
