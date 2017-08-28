package schoolmate.parent;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Parent;

public class ViewGrades200 extends Parent{	
	@Before
	public void init() {tester.clickLinkWithExactText("Soy El Estudiante");
		tester.assertMatch("Soy El Estudiante's Classes");
		
		tester.clickLinkWithText("Fortgeschrittene Mat");
		
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("5", "3", "Grades");
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

