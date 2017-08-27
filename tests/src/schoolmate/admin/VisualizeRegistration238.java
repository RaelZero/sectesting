package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class VisualizeRegistration238 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Registration");
		tester.assertMatch("Registration");
		
		tester.setWorkingForm("registration");
		addSubmitButton("//form[@name='registration']");
	}

	@Test
	public void testPage() {
		tester.setTextField("page", "1 '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.clickButtonWithText("Show in Grid");
		
		tester.assertMatch("Soy El Estudiante's Schedule");
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("29", "Soy El Estudiante's Schedule");
	}
}
