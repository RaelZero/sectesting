package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageSemesters268 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Semesters");
		tester.assertMatch("Manage Semesters");
		
		tester.setWorkingForm("semesters");
		addSubmitButton("//form[@name='semesters']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "5", "Manage Semesters");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("5", "Manage Semesters");
	}
	
	@Test
	public void testOnpage() {
		tester.setTextField("page2", "5");
		
		tester.setTextField("onpage", "1 '> <a href=\"www.unitn.it\">XSS on onpage</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("Manage Semesters");
		tester.assertLinkNotPresentWithText("XSS on onpage");
	}
}
