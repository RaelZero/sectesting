package schoolmate.student;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Student;

public class ViewClassSettings88 extends Student{	
	@Before
	public void init() {
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("4", "1", "Class Settings");
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

