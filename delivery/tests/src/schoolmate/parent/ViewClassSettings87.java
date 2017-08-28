package schoolmate.parent;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Parent;

public class ViewClassSettings87 extends Parent{	
	@Before
	public void init() {
		tester.clickLinkWithExactText("Soy El Estudiante");
		tester.assertMatch("Soy El Estudiante's Classes");
		
		tester.clickLinkWithText("Fortgeschrittene Mat");
		tester.assertMatch("Class Settings");
		
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("5", "1", "Class Settings");
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

