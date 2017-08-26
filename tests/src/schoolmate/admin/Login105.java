package schoolmate.admin;

import org.junit.After;
import org.junit.Test;

import schoolmate.Admin;

public class Login105 extends Admin {	
	@Test
	public void testPage() {
		tester.setWorkingForm("admin");
		addSubmitButton("//form[@name='admin']");
		tester.setTextField("logout", "");
		tester.setTextField("page", "0 '> <a href=\"http://unitn.it\">XSS on page</a> <br '");
		tester.submit();
		
		tester.assertMatch("Login Text");
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	@Test
	public void testSiteMessage() {		
		tester.clickLinkWithText("School");
		
		//Check for page navigation
		tester.assertMatch("Manage School Information");
		
		tester.setTextField("sitemessage", "<a href=\"http://unitn.it\">XSS on sitemessage</a>");
		tester.clickButtonWithText(" Update ");
		
		tester.assertMatch("Manage School Information");
		
		tester.clickLinkWithText("Log Out");
		
		tester.assertLinkNotPresentWithText("XSS on sitemessage");
	}
	
	@After
	public void cleanup() {
		tester.beginAt("index.php");
		tester.setTextField("username", "test");
		tester.setTextField("password", "test");
		tester.submit();
		
		tester.assertMatch("Manage Classes");
		tester.clickLinkWithText("School");
		tester.assertMatch("Manage School Information");
		
		tester.setTextField("sitemessage", "MOTD");
		tester.clickButtonWithText(" Update ");
	}
}
