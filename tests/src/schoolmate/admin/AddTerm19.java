package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class AddTerm19 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Terms");
		tester.assertMatch("Manage Terms");
		
		tester.setWorkingForm("terms");
		addSubmitButton("//form[@name='terms']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "8", "Add Term");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("8", "Add Term");
	}
}
