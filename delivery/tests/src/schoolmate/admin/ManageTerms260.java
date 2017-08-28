package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageTerms260 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Terms");
		tester.assertMatch("Manage Terms");
		
		tester.setWorkingForm("terms");
		addSubmitButton("//form[@name='terms']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "6", "Manage Terms");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("6", "Manage Terms");
	}
	
	@Test
	public void testOnpage() {
		this.genericTestOnpage("6", "Manage Terms");
	}
}
