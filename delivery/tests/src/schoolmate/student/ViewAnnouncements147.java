package schoolmate.student;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Student;

public class ViewAnnouncements147 extends Student{
	@Before
	public void init() {
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("4", "4", "View Announcements");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("4", "View Announcements");
	}
	
	@Test
	public void testOnpage() {
		tester.clickLinkWithText("Announcements");
		tester.assertMatch("View Announcements");
		
		tester.setWorkingForm("announcements");
		addSubmitButton("//form[@name='announcements']");
		tester.setTextField("page2", "4");
		
		tester.setTextField("onpage", "1 '> <a href=\"www.unitn.it\">XSS on onpage</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("View Announcements");
		tester.assertLinkNotPresentWithText("XSS on onpage");
	}
}
