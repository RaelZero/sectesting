package schoolmate.admin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageSemesters234 extends Admin {
	@Before
	public void init() {
		tester.clickLinkWithText("Terms");
		tester.clickButtonWithText("Add");
		
		tester.assertMatch("Add New Term");		
		tester.setWorkingForm("addterm");
		tester.setTextField("title", "<i>HTML</i>");
		tester.setTextField("startdate", "01/01/2016");
		tester.setTextField("enddate", "12/31/2016");
		
		tester.clickButtonWithText("Add Term");
		
		tester.assertMatch("Manage Terms");
		
		tester.clickLinkWithText("Semesters");
		tester.assertMatch("Manage Semesters");
		
		tester.clickButtonWithText("Add");
		tester.assertMatch("Add New Semester");		
		tester.setWorkingForm("addsemester");
		tester.setTextField("title", "Buggy");
		
		//Select the buggy term
		try {
			tester.selectOption("term", "HTML");
		} catch (AssertionError e) {
			tester.selectOption("term", "<i>HTML&l");
		}
		
		tester.setTextField("startdate", "01/01/2016");
		tester.setTextField("middate", "02/01/2016");
		tester.setTextField("enddate", "02/02/2016");
		
		tester.clickButtonWithText("Add Semester");
	}
	
	@Test
	public void test() {
		tester.assertMatch("Manage Semesters");
		
		tester.assertElementNotPresentByXPath("//i");
	}
	
	@After
	public void cleanup() {
		tester.beginAt("index.php");
		tester.setTextField("username", "test");
		tester.setTextField("password", "test");
		tester.submit();
		
		tester.clickLinkWithText("Terms");
		
		tester.assertMatch("Manage Terms");
		
		tester.setWorkingForm("terms");
		tester.clickElementByXPath("(//input[@type='checkbox'])[2]");

		tester.setExpectedJavaScriptConfirm("Deleteing a term will also delete the semesters, classes, bulletins, tardies, attendance, assignments, and registrations that occured during that term. \n" + 
				" \n" + 
				"Are you sure?", true);
		tester.clickButtonWithText("Delete");
		
	}
}
