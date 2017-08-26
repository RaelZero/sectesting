package schoolmate.teacher;

import schoolmate.Teacher;
import org.junit.*;

public class ManageGrades316 extends Teacher{	
	@Before
	public void init() {
		tester.setWorkingForm("teacher");
		addSubmitButton("//form[@name='teacher']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("2", "3", "Grades");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("3", "Grades");
	}
	
	@Test
	public void testSelectclass() {
		this.genericTestSelectclass("1", "3", "Grades");
	}
}

