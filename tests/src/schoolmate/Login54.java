package schoolmate;
import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.*;

public class Login54 {
	
	private WebTester tester;
	private String originalMessage = null;

	@Before
	public void prepare() {
		tester = new WebTester();
		tester.setBaseUrl("http://192.168.56.102/schoolmate/");
	}
	
	@Test
	public void test() {
		tester.beginAt("index.php");
		tester.setTextField("username", "test");
		tester.setTextField("password", "test");
		tester.submit();
		
		//Check for successful login
		tester.assertMatch("Manage Classes");
		
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
