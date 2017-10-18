package upskills.autotagging.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upskills.autotagging.dao.IssueDao;
import upskills.autotagging.model.Issue;
import upskills.autotagging.service.IssueService;

@Service("issueService")
@Transactional
public class IssueServiceImpl implements IssueService {
	
	@Autowired
	private IssueDao issuesDao;

	@Override
	public void createIssue(Issue issue) {
		issuesDao.create(issue);
		
	}

	@Override
	public void deleteIssue(Issue issue) {
		issuesDao.delete(issue);
		
	}

	@Override
	public void updateIssue(Issue issue) {
		issuesDao.update(issue);
		
	}

	@Override
	public List<Issue> getAllIssue() {
		issuesDao.getAll();
		return null;
	}

}
