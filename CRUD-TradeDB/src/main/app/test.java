import java.io.File;
import java.net.URL;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import upskills.autotagging.model.Issue;
import upskills.autotagging.model.Trade;
import upskills.autotagging.service.IssueService;
import upskills.autotagging.service.TradeService;



public class test {

	public static void main(String[] args) {
		
//		File file = new File("applicationContext.xml");
//		//URL url = Thread.class.getClassLoader().getResource("applicationContext.xml");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(url.toString());
//		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		
		//Object obj = context.getBean("issueService");
		IssueService issueService = context.getBean(IssueService.class);		
		TradeService tradeService = context.getBean(TradeService.class);
		
		//System.out.println(obj.getClass());
		//System.out.println(issueService.getClass());
		
		//Issue issue = new Issue();
		//issue.setFieldValues("test add new issue 1001");
		
		//issueService.createIssue(issue);

		//IssueService issueService;
		//System.out.println("Load config");
		
		List listIssue = (List) issueService.getAllIssue();
		System.out.println(listIssue.size());
		
		List trades = (List) tradeService.getAllTrade();
		System.out.println(trades.size());
		
	}

}
