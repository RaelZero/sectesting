package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class EditSemester85 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Semesters");
		tester.assertMatch("Manage Semesters");
		
		tester.setWorkingForm("semesters");
		addSubmitButton("//form[@name='semesters']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		this.genericTestPage("1", "13", "Edit Semester");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		this.genericTestPage2("13", "Edit Semester");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
