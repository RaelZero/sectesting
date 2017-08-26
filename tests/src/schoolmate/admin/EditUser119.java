package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class EditUser119 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Users");
		tester.assertMatch("Manage Users");
		
		tester.setWorkingForm("users");
		addSubmitButton("//form[@name='users']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		this.genericTestPage("1", "15", "Edit User");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		this.genericTestPage2("15", "Edit User");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
