package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

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
		tester.setTextField("page2", "11");
		tester.setTextField("page", "1 '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		tester.setTextField("page2", "11 '><a href=\"http://unitn.it\">XSS on page2</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page2");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
