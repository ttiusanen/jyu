package fi.jyu.issuetracker.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.jyu.issuetracker.dao.models.Issue;
import fi.jyu.issuetracker.dao.repositories.IssueRepository;

@Controller
public class FormSubmissionController {
	
	@Autowired
	private IssueRepository issueRepository;
	
	@GetMapping("/newIssue")
	public String issueForm(Model model) {
	    model.addAttribute("issue", new Issue());
	    return "index";
	}
	
	@PostMapping("/newIssue")
	public String issueSubmit(@ModelAttribute Issue issue) {
		issueRepository.save(issue);
	    return "issues";
	}
	
	@GetMapping("/issues")
	@ResponseBody
	public List<Issue> issues() {
	    return issueRepository.findAll();
	}
}
