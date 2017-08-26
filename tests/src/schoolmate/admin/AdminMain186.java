package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class AdminMain186 extends Admin{
	@Before
	public void init() {
		tester.setWorkingForm("admin");
		addSubmitButton("//form[@name='admin']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "0", "Manage Classes");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("0", "Manage Classes");
	}
}
