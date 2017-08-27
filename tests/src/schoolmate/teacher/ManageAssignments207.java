package schoolmate.teacher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import schoolmate.Teacher;

public class ManageAssignments207 extends Teacher{
	@Before
	public void init() {
		// As Admin, create a course with a malicious name 
		tester.beginAt("index.php");
		tester.setTextField("username", "test");
		tester.setTextField("password", "test");
		tester.submit();
		
		tester.clickLinkWithText("Classes");
		
		tester.setWorkingForm("classes");
		tester.clickButtonWithText("Add");
		
		tester.setWorkingForm("addclass");
		tester.setTextField("title", "<a href=\"/\">XSS</a>");
		tester.setTextField("sectionnum", "1");
		tester.setTextField("roomnum", "1");
		tester.setTextField("periodnum", "1");
		
		tester.clickButtonWithText("Add Class");
	}

	@Test
	public void testCoursename() {
		tester.beginAt("index.php");
		tester.setTextField("username", "teacher");
		tester.setTextField("password", "test");
		tester.submit();		
		
		try{
			tester.clickLinkWithText("XSS");
		}
		catch(AssertionError e) {
			//The sanitized course name contains the "href" string, so I can click on that link
			tester.clickLinkWithText("href");
		}
		
		tester.assertMatch("Class Settings");
		
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		
		tester.assertLinkNotPresentWithText("XSS");		
	}
	
	@After
	public void cleanup() {
		//As admin, perform cleanup
		tester.beginAt("index.php");
		tester.setTextField("username", "test");
		tester.setTextField("password", "test");
		tester.submit();
		
		tester.setWorkingForm("classes");
		tester.clickElementByXPath("(//input[@type='checkbox'])[2]");
		

		tester.setExpectedJavaScriptConfirm("Deleteing a class will also delete the class bulletins, tardies, attendance, assignments, and registrations that occured during that class. \n" + 
				" \n" + 
				"Are you sure?", true);
		tester.clickButtonWithText("Delete");
		
		tester.assertMatch("Manage Classes");
	}
}
