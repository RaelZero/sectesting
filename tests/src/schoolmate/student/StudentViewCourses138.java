package schoolmate.student;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Student;

public class StudentViewCourses138 extends Student{
	@Before
	public void init() {
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("4", "0", "Soy El Estudiante's Classes");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("0", "Soy El Estudiante's Classes");
	}
}
