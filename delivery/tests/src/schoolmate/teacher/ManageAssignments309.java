package schoolmate.teacher;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Teacher;

public class ManageAssignments309 extends Teacher{	
	@Before
	public void init() {
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		
		tester.setWorkingForm("assignments");
		addSubmitButton("//form[@name='assignments']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("2", "2", "Manage Assignments");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("2", "Manage Assignments");
	}
	
	@Test
	public void testSelectclass() {
		this.genericTestSelectclass("1", "2", "Grades");
	}
	
	@Test
	public void testOnpage() {
		tester.setTextField("page2", "2");
		
		tester.setTextField("onpage", "1 '> <a href=\"www.unitn.it\">XSS on onpage</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("Manage Assignments");
		tester.assertLinkNotPresentWithText("XSS on onpage");
	}
}

