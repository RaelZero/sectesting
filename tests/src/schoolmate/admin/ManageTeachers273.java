package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageTeachers273 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Teachers");
		tester.assertMatch("Manage Teachers");
		
		tester.setWorkingForm("teachers");
		addSubmitButton("//form[@name='teachers']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "3", "Manage Teachers");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("3", "Manage Teachers");
	}
	
	@Test
	public void testOnpage() {
		this.genericTestOnpage("3", "Manage Teachers");
	}
}
