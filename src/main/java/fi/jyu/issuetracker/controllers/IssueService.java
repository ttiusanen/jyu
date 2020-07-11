package fi.jyu.issuetracker.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

/**
 * Controller class for handling issue submits and issue database operations.
 */
@RestController
public class IssueService {
	
	@Autowired
	private IssueRepository issueRepository;
	
	/**
	 * Creates a new issue
	 * @param issue
	 * @return
	 */
	@PostMapping("/api/issues")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Issue issueSubmit(@Valid @RequestBody Issue issue) {
		//issue.setImportance(Importance.MEDIUM);
		issue.setStatus(Status.OPEN);
		Issue createdIssue = issueRepository.save(issue);
        return createdIssue;
	}
	
	/**
	 * Returns all issues 
	 * @return issues
	 */
	@GetMapping("/api/issues")
	public List<Issue> issues() {
	    return issueRepository.findAll();
	}
	
	/**
	 * Returns issue by id if id exists
	 * @param id issue id
	 * @return issue.
	 */
	@GetMapping("/api/issues/{id}")
    public Issue getIssueByID(@PathVariable Long id) {		
		Optional<Issue> issue = issueRepository.findById(id);
		return issue.isPresent() ? issue.get() : null;
	}

	/**
	 * Updates an issue if issue with given id exists
	 * @param issue issue to be updated
	 */
	@PostMapping("/api/issues/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void updateIssue(@RequestBody Issue issue){
		Long id = issue.getId();
		Optional<Issue> oldIssue = issueRepository.findById(id);
		if (oldIssue.isPresent()){
			Issue updatedIssue = oldIssue.get();
			updatedIssue.setSummary(issue.getSummary());
			updatedIssue.setDescription(issue.getDescription());
			updatedIssue.setImportance(issue.getImportance());
			updatedIssue.setStatus(issue.getStatus());
			issueRepository.save(updatedIssue);
		}
	}
	
	/**
	 * Deletes issue by id if id exists
	 * @param id issue id
	 */
	@DeleteMapping("/api/issues/{id}")
    public void deleteIssue(@PathVariable Long id) {
		if (issueRepository.existsById(id)) {
			issueRepository.deleteById(id);
		}      
    }
}
