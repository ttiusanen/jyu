package fi.jyu.issuetracker.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.jyu.issuetracker.dao.models.Issue;
import fi.jyu.issuetracker.dao.repositories.IssueRepository;

@RestController
public class FormSubmissionController {
	
	@Autowired
	private IssueRepository issueRepository;
	
//	@GetMapping("/api/issues")
//	public String issueForm(Model model) {
//	    model.addAttribute("issue", new Issue());
//	    return "index";
//	}
	
	@PostMapping("/api/issues")
	@CrossOrigin(origins = "http://localhost:3000")
	public String issueSubmit(@RequestBody Issue issue) {
		issueRepository.save(issue);
	    return "Posted issue: \n" + issue;
	}
	
	@GetMapping("/api/issues")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Issue> issues() {
	    return issueRepository.findAll();
	}
}
