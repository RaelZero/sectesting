package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class EditTerm44 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Terms");
		tester.assertMatch("Manage Terms");
		
		tester.setWorkingForm("terms");
		addSubmitButton("//form[@name='terms']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		this.genericTestPage("1", "12", "Edit Term");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		this.genericTestPage2("12", "Edit Term");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
