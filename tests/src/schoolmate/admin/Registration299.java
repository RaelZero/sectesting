package schoolmate.admin;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class Registration299 extends Admin{
	@Before
	public void init() {
		tester.setWorkingForm("admin");
		addSubmitButton("//form[@name='admin']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "26", "Registration");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("26", "Registration");
	}
}
