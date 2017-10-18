package upskills.autotagging.service;

import java.util.List;

import upskills.autotagging.model.Issue;



public interface IssueService {
	
	public void createIssue(Issue issue);
	
	public void deleteIssue(Issue issue);
	
	public void updateIssue(Issue issue);
	
	public List<Issue> getAllIssue(); 
	
}
