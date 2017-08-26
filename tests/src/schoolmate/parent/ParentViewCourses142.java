package schoolmate.parent;

import org.junit.*;
import schoolmate.Parent;

public class ParentViewCourses142 extends Parent{
	@Before
	public void init() {
		tester.setWorkingForm("student");
		addSubmitButton("//form[@name='student']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("5", "5", "Soy El Estudiante's Classes");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("5", "Soy El Estudiante's Classes");
	}
	
	@Test
	public void testStudent() {
		tester.setTextField("student", "1 -- '> <a href=\"www.unitn.it\">XSS on student</a> <br '");
		tester.setTextField("page2", "5");
		
		tester.submit();
		
		tester.assertMatch("Soy El Estudiante's Classes");
		tester.assertLinkNotPresentWithText("XSS on student");
	}
}
