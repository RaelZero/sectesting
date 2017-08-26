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
		tester.setTextField("page2", "12");
		tester.setTextField("page", "1 '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		tester.setTextField("page2", "12 '><a href=\"http://unitn.it\">XSS on page2</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page2");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
