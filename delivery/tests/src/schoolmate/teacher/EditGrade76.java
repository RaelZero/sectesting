package schoolmate.teacher;

import org.junit.Before;
import org.junit.Test;
import schoolmate.Teacher;

public class EditGrade76 extends Teacher{	
	@Before
	public void init() {
		tester.clickLinkWithText("Grades");
		tester.assertMatch("Grades");
		
		tester.clickElementByXPath("//input[@type='checkbox']");
		tester.clickButtonWithText("Edit");
		tester.assertMatch("Edit Grade");
		
		tester.setWorkingForm("editgrade");
		addSubmitButton("//form[@name='editgrade']");
	}
	
	@Test
	public void testPage() {
		this.genericTestPage("2", "7", "Edit Grade");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("7", "Edit Grade");
	}
	
	@Test
	public void testSelectclass() {
		this.genericTestSelectclass("1", "7", "Edit Grade");
	}
	
	@Test
	public void testDelete() {
		tester.clickLinkWithText("Grades");
		tester.assertMatch("Grades");
		
		tester.setWorkingForm("grades");
		
		tester.checkCheckbox("delete[]");
		tester.getElementByXPath("//input[@type='checkbox']")
		.setAttribute("value", "1 '><a href=\"http://unitn.it\">XSS on delete</a><br'");
		
		tester.clickButtonWithText("Edit");

		tester.assertLinkNotPresentWithText("XSS on delete");
	}
	
	@Test
	public void testAssignment() {
		tester.setTextField("assignment", "2 '><a href=\"http://unitn.it\">XSS on assignment</a><br'");
		tester.setTextField("page2", "7");
		
		tester.submit();
		
		tester.assertLinkNotPresentWithText("XSS on assignment");
	}
}

