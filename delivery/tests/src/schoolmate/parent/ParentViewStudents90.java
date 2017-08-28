package schoolmate.parent;

import org.junit.Before;
import org.junit.Test;

import schoolmate.Parent;

public class ParentViewStudents90 extends Parent{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Soy El Estudiante");
		tester.assertMatch("Soy El Estudiante's Classes");
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("5", "0", "Students of Ik ben de vader");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("0", "Students of Ik ben de vader");
	}
}
