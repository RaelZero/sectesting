package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class EditClass239 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Classes");
		tester.assertMatch("Manage Classes");
		
		tester.setWorkingForm("classes");
		addSubmitButton("//form[@name='classes']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		this.genericTestPage("1", "11", "Edit Class");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		this.genericTestPage2("11", "Edit Class");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
