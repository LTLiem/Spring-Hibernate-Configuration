package upskills.autotagging.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import upskills.autotagging.dao.IssueDao;
import upskills.autotagging.model.Issue;

@Repository
public class HbnIssueDao extends AbstractHbnDao<Issue> implements IssueDao {
	//Implement abstract methods of Issue
}
