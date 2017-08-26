package schoolmate.teacher;

import org.junit.*;
import schoolmate.Teacher;

public class TeacherMain180 extends Teacher{
	@Before
	public void init() {
		tester.setWorkingForm("teacher");
		addSubmitButton("//form[@name='teacher']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("2", "0", "Je Suis Le Professeur's Classes");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("0", "Je Suis Le Professeur's Classes");
	}
	
	@Test
	public void testSelectclass() {
		this.genericTestSelectclass("1", "0", "Je Suis Le Professeur's Classes");
	}
}
