package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class AddParent93 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Parents");
		tester.assertMatch("Manage Parents");
		
		tester.setWorkingForm("parents");
		addSubmitButton("//form[@name='parents']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "23", "Add New Parent");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("23", "Add New Parent");
	}
}
