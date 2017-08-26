package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class EditAnnouncements41 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Announcements");
		tester.assertMatch("Manage Announcements");
		
		tester.setWorkingForm("announcements");
		addSubmitButton("//form[@name='announcements']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		tester.setTextField("page2", "19");
		tester.setTextField("page", "1 '><a href=\"http://unitn.it\">XSS on page</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		tester.setTextField("page2", "19 '><a href=\"http://unitn.it\">XSS on page2</a><br'");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on page2");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
