package schoolmate.parent;

import org.junit.*;
import schoolmate.Parent;

public class ParentMain194 extends Parent{
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
	
	@Test
	public void testSelectclass() {
		this.genericTestSelectclass("1", "0", "Students of Ik ben de vader");
	}
	
	@Test
	public void testStudent() {
		tester.setTextField("student", "1 -- '> <a href=\"www.unitn.it\">XSS on student</a> <br '");
		tester.setTextField("page2", "0");
		
		tester.submit();
		
		tester.assertMatch("Students of Ik ben de vader");
		tester.assertLinkNotPresentWithText("XSS on student");
	}
}
