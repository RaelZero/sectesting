package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class ManageAttendance272 extends Admin{
	@Before
	public void init() {
		tester.setWorkingForm("admin");
		addSubmitButton("//form[@name='admin']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "30", "Attendance");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("30", "Attendance");
	}
}
