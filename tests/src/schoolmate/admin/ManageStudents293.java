package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageStudents293 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Students");
		tester.assertMatch("Manage Students");
		
		tester.setWorkingForm("students");
		addSubmitButton("//form[@name='students']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "2", "Manage Students");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("2", "Manage Students");
	}
	
	@Test
	public void testOnpage() {
		tester.setTextField("page2", "2");
		
		tester.setTextField("onpage", "1 '> <a href=\"www.unitn.it\">XSS on onpage</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("Manage Students");
		tester.assertLinkNotPresentWithText("XSS on onpage");
	}
}
