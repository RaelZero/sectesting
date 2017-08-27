package schoolmate.teacher;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Teacher;

public class ViewAnnouncements148 extends Teacher{
	@Before
	public void init() {
		tester.assertMatch("Class Settings");
		
		tester.setWorkingForm("teacher");
		addSubmitButton("//form[@name='teacher']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("2", "9", "View Announcements");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("9", "View Announcements");
	}
	
	@Test
	public void testOnpage() {
		tester.clickLinkWithText("Announcements");
		tester.assertMatch("View Announcements");
		
		tester.setWorkingForm("announcements");
		addSubmitButton("//form[@name='announcements']");
		tester.setTextField("page2", "9");
		
		tester.setTextField("onpage", "1 '> <a href=\"www.unitn.it\">XSS on onpage</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("View Announcements");
		tester.assertLinkNotPresentWithText("XSS on onpage");
	}
}
