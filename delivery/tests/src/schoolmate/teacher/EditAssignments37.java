package schoolmate.teacher;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Teacher;

public class EditAssignments37 extends Teacher{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Assignments");
		tester.assertMatch("Manage Assignments");
		
		tester.setWorkingForm("assignments");
		addSubmitButton("//form[@name='assignments']");
	}

	@Test
	public void testPage() {		
		tester.checkCheckbox("delete[]");
		tester.setTextField("page2", "5");
		tester.setTextField("page", "2 '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		tester.setTextField("page2", "5 '><a href=\"http://unitn.it\">XSS on page2</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page2");
	}
	
	@Test
	public void testSelectclass() {
		tester.setTextField("page2", "5");
		tester.setTextField("selectclass", "1 -- '><a href=\"http://unitn.it\">XSS on selectclass</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on selectclass");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
