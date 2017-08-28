package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class AddClass141 extends Admin{
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
}
