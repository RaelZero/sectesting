package schoolmate.parent;

import schoolmate.Parent;
import org.junit.*;

public class ViewGrades200 extends Parent{	
	@Before
	public void init() {
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

