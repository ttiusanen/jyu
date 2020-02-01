package fi.jyu.issuetracker.models;

import java.time.LocalDateTime;

public class Issue {
	//private User createdBy;
	private LocalDateTime creationTime;
	private Importance importance;
	private User assignedTo;
	private String description;
	//private LocalDateTime dueDate;
	private Status status;
	
	
	public Issue(LocalDateTime creationTime, Importance importance, User assignedTo, String description,
			Status status) {
		this.creationTime = creationTime;
		this.importance = importance;
		this.assignedTo = assignedTo;
		this.description = description;
		this.status = status;
	}

	public void changeStatus(Status status) {
		this.status = status;
	}
	
	
}
