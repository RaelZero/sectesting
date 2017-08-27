package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class AddClass269 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Classes");
		tester.assertMatch("Manage Classes");
		
		tester.setWorkingForm("classes");
		addSubmitButton("//form[@name='classes']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "9", "Add New Class");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("9", "Add New Class");
	}
	
	/*
	@Test
	public void testFullyear() {
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Class");
		
		tester.setWorkingForm("addclass");
		addSubmitButton("//form[@name='addclass']");
		
		tester.setTextField("page2", "9");		
		tester.setTextField("fullyear", "1 '><a href=\"http://unitn.it\">XSS on fullyear</a><br'");
		
		tester.submit();
		
		tester.assertMatch("Add New Class");
		tester.assertLinkNotPresent("XSS on fullyear");
	}*/
}
