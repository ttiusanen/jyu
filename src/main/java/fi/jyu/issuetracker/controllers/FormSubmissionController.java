package fi.jyu.issuetracker.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.jyu.issuetracker.models.Issue;

@Controller
public class FormSubmissionController {
	
	  @GetMapping("/newIssue")
	  public String greetingForm(Model model) {
	    model.addAttribute("issue", new Issue());
	    return "index";
	  }

	  @PostMapping("/newIssue")
	  public String greetingSubmit(@ModelAttribute Issue issue) {
	    return "issues";
	  }
}
