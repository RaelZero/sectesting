package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class GradeReport241 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Students");
		tester.assertMatch("Manage Students");
		
		tester.setWorkingForm("students");
		addSubmitButton("//form[@name='students']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "28", "Grade Report");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("28", "Grade Report");
	}
}
