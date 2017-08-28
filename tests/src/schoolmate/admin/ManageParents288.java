package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageParents288 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Parents");
		tester.assertMatch("Manage Parents");
		
		tester.setWorkingForm("parents");
		addSubmitButton("//form[@name='parents']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "22", "Manage Parents");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("22", "Manage Parents");
	}
	
	@Test
	public void testOnpage() {
		this.genericTestOnpage("22", "Manage Parents");
	}
}
