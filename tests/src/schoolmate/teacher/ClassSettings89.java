package schoolmate.teacher;

import schoolmate.Teacher;
import org.junit.*;

public class ClassSettings89 extends Teacher{	
	@Before
	public void init() {
		tester.setWorkingForm("teacher");
		addSubmitButton("//form[@name='teacher']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("2", "1", "Class Settings");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("1", "Class Settings");
	}
	
	@Test
	public void testSelectclass() {
		this.genericTestSelectclass("1", "1", "Class Settings");
	}
}

