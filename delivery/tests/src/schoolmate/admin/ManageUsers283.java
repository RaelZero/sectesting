package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageUsers283 extends Admin {
	@Before
	public void init() {
		tester.clickLinkWithExactText("Users");
		tester.assertMatch("Manage Users");

		tester.setWorkingForm("users");
		addSubmitButton("//form[@name='users']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "10", "Manage Users");
	}

	@Test
	public void testPage2() {
		this.genericTestPage2("10", "Manage Users");
	}

	@Test
	public void testOnpage() {
		this.genericTestOnpage("10", "Manage Users");
	}
}
