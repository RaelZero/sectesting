package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class EditTeacher111 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Teachers");
		tester.assertMatch("Manage Teachers");
		
		tester.setWorkingForm("teachers");
		addSubmitButton("//form[@name='teachers']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		this.genericTestPage("1", "17", "Edit Teacher");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		this.genericTestPage2("17", "Edit Teacher");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
