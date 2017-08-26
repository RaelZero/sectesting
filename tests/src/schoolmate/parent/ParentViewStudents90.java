package schoolmate.parent;

import org.junit.*;
import schoolmate.Parent;

public class ParentViewStudents90 extends Parent{
	@Before
	public void init() {
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
