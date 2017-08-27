package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageAnnouncements257 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Announcements");
		tester.assertMatch("Manage Announcements");
		
		tester.setWorkingForm("announcements");
		addSubmitButton("//form[@name='announcements']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "4", "Manage Announcements");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("4", "Manage Announcements");
	}
	
	@Test
	public void testOnpage() {
		tester.setTextField("page2", "4");
		
		tester.setTextField("onpage", "1 '> <a href=\"www.unitn.it\">XSS on onpage</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("Manage Announcements");
		tester.assertLinkNotPresentWithText("XSS on onpage");
	}
}
