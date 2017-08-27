package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class AddUser18 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Users");
		tester.assertMatch("Manage Users");
		
		tester.setWorkingForm("users");
		addSubmitButton("//form[@name='users']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "14", "Add User");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("14", "Add User");
	}
}
