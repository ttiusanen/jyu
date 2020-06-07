package fi.jyu.issuetracker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fi.jyu.issuetracker.dao.models.Status;
import fi.jyu.issuetracker.dao.models.Issue;
import fi.jyu.issuetracker.dao.repositories.IssueRepository;

/*
Controller class for handling issue submits and issue database operations.
*/
@RestController
public class IssueService {
	
	@Autowired
	private IssueRepository issueRepository;
	
	// Creates a new issue
	@PostMapping("/api/issues")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Issue issueSubmit(@RequestBody Issue issue) {
		//issue.setImportance(Importance.MEDIUM);
		issue.setStatus(Status.OPEN);
		Issue createdIssue = issueRepository.save(issue);
        return createdIssue;
	}
	
	// Returns all issues 
	@GetMapping("/api/issues")
	public List<Issue> issues() {
	    return issueRepository.findAll();
	}
	
	// Returns issue by id
	@GetMapping("/api/issues/{id}")
    public Optional<Issue> getIssueByID(@PathVariable Long id) {
        return issueRepository.findById(id);
	}
	
	// Deletes issue by id if id exists
	@DeleteMapping("/api/issues/{id}")
    public void deleteIssue(@PathVariable Long id) {
		if (issueRepository.existsById(id)) {
			issueRepository.deleteById(id);
		}      
    }
}
