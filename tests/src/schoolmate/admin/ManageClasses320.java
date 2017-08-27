package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageClasses320 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Classes");
		tester.assertMatch("Manage Classes");
		
		tester.setWorkingForm("classes");
		addSubmitButton("//form[@name='classes']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "0", "Manage Classes");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("0", "Manage Classes");
	}
	
	@Test
	public void testOnpage() {
		tester.setTextField("page2", "0");
		
		tester.setTextField("onpage", "1 '> <a href=\"www.unitn.it\">XSS on onpage</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("Manage Classes");
		tester.assertLinkNotPresentWithText("XSS on onpage");
	}
}
