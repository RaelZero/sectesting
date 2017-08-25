package schoolmate.admin;

import org.junit.After;
import org.junit.Test;

import schoolmate.Admin;

public class Login54 extends Admin {
	private String originalMessage = null;
	
	@Test
	public void testSiteText() {		
		tester.clickLinkWithText("School");
		
		//Check for page navigation
		tester.assertMatch("Manage School Information");
		
		originalMessage = tester.getElementByXPath("html//textarea[@name='sitetext']").getTextContent();
		
		tester.setTextField("sitetext", "<a href=\"http://unitn.it\">XSS on sitetext</a>");
		tester.clickButtonWithText(" Update ");
		
		tester.assertMatch("Manage School Information");
		
		tester.clickLinkWithText("Log Out");
		
		tester.assertLinkNotPresentWithExactText("XSS on sitetext");
	}
	
	@After
	public void cleanup() {
		if (originalMessage != null) {
			tester.beginAt("index.php");
			tester.setTextField("username", "test");
			tester.setTextField("password", "test");
			tester.submit();
			
			tester.assertMatch("Manage Classes");
			tester.clickLinkWithText("School");
			tester.assertMatch("Manage School Information");
			
			tester.setTextField("sitetext", originalMessage);
			tester.clickButtonWithText(" Update ");
		}
	}
}
