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
		tester.setTextField("page2", "24");
		tester.setTextField("page", "1 '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		tester.setTextField("page2", "24 '><a href=\"http://unitn.it\">XSS on page2</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page2");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
