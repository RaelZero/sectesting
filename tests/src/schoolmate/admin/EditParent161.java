package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class EditParent161 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Parents");
		tester.assertMatch("Manage Parents");
		
		tester.setWorkingForm("parents");
		addSubmitButton("//form[@name='parents']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		this.genericTestPage("1", "24", "Edit Parent");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		this.genericTestPage2("24", "Edit Parent");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
