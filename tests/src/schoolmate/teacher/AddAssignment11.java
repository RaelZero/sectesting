package schoolmate.teacher;

import schoolmate.Teacher;
import org.junit.*;

public class AddAssignment11 extends Teacher{
	@Before
	public void init() {
		tester.clickLinkWithText("Assignments");
		tester.assertMatch("Manage Assignments");
		
		tester.setWorkingForm("assignments");
		addSubmitButton("//form[@name='assignments']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("2", "4");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("4");
	}
	
	@Test
	public void testSelectclass() {
		this.genericTestSelectclass("1", "4");
	}
}

