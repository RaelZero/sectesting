package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class DeficiencyReport191 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Students");
		tester.assertMatch("Manage Students");
		
		tester.setWorkingForm("students");
		addSubmitButton("//form[@name='students']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "27", "Deficiency Report");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("27", "Deficiency Report");
	}
}
