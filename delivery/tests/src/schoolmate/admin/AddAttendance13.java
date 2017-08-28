package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class AddAttendance13 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Attendance");
		tester.assertMatch("Attendance");
		
		tester.setWorkingForm("registration");
		tester.clickButtonWithText("Add");
		
		tester.setWorkingForm("addattendance");
		addSubmitButton("//form[@name='addattendance']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "31", "Add New Attendance Record");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("31", "Add New Attendance Record");
	}
	
	@Test
	public void testStudent() {
		tester.setTextField("page2", "31");
		tester.setTextField("student", "1 '> <a href=\"www.unitn.it\">XSS on student</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("Add New Attendance Record");
		tester.assertLinkNotPresentWithText("XSS on student");
	}
	
	@Test
	public void testSemester() {
		tester.setTextField("page2", "31");
		tester.setTextField("semester", "1 '> <a href=\"www.unitn.it\">XSS on semester</a> <br '");
		
		tester.submit();
		
		tester.assertMatch("Add New Attendance Record");
		tester.assertLinkNotPresentWithText("XSS on semester");
	}
}
