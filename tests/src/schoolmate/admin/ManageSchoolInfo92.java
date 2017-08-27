package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageSchoolInfo92 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("School");
		tester.assertMatch("Manage School Information");
		
		tester.setWorkingForm("info");
		addSubmitButton("//form[@name='info']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "1", "Manage School Information");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("1", "Manage School Information");
	}
	
	
}
