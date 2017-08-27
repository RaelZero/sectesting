package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class AddSemester71 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Semesters");
		tester.assertMatch("Manage Semesters");
		
		tester.setWorkingForm("semesters");
		addSubmitButton("//form[@name='semesters']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "7", "Add New Semester");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("7", "Add New Semester");
	}
}
