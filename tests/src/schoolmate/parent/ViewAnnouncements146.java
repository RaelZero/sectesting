package schoolmate.parent;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Parent;

public class ViewAnnouncements146 extends Parent{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Soy El Estudiante");
		tester.assertMatch("Soy El Estudiante's Classes");
		tester.clickLinkWithExactText("Fortgeschrittene Mat");
		tester.assertMatch("Class Settings");
		
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("5", "4", "View Announcements");
	}
	
	@Test
	public void testPage2(){
		tester.setTextField("selectclass", "1");
		tester.setTextField("student", "1");
		
		tester.setTextField("page2", "4 '><a href=\"http://unitn.it\">XSS on page2</a><br'");
		
		tester.submit();
		
		tester.assertMatch("View Announcements");
		tester.assertLinkNotPresentWithText("XSS on page2");
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
