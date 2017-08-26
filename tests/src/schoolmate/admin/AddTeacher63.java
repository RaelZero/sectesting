package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class AddTeacher63 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Teachers");
		tester.assertMatch("Manage Teachers");
		
		tester.setWorkingForm("teachers");
		addSubmitButton("//form[@name='teachers']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "16", "Add New Teacher");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("16", "Add New Teacher");
	}
}
