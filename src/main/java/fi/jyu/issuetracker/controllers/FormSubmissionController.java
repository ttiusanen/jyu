package fi.jyu.issuetracker.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.jyu.issuetracker.dao.models.Status;
import fi.jyu.issuetracker.dao.models.Issue;
import fi.jyu.issuetracker.dao.repositories.IssueRepository;

@RestController
public class FormSubmissionController {
	
	@Autowired
	private IssueRepository issueRepository;
	
	@PostMapping("/api/issues")
	//@CrossOrigin(origins = "http://localhost:3000")
	public Issue issueSubmit(@RequestBody Issue issue) {
		//issue.setImportance(Importance.MEDIUM);
		issue.setStatus(Status.OPEN);
		Issue createdIssue = issueRepository.save(issue);
        return createdIssue;
	}
	
	@GetMapping("/api/issues")
	public List<Issue> issues() {
	    return issueRepository.findAll();
	}
	
	@GetMapping("/api/issues/{id}")
    public Optional<Issue> read(@PathVariable Long id) {
        return issueRepository.findById(id);
    }
}
