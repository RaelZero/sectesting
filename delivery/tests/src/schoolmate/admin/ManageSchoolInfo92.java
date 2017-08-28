package schoolmate.admin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import schoolmate.Admin;

public class ManageSchoolInfo92 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("School");
		tester.assertMatch("Manage School Information");
		
		tester.setWorkingForm("info");
		addSubmitButton("//form[@name='info']");
	}

	@Test
	public void testPage() {
		this.genericTestPage("1", "1", "Manage School Information");
	}
	
	@Test
	public void testPage2(){
		this.genericTestPage2("1", "Manage School Information");
	}
	
	@Test
	public void testPhone() {
		tester.setTextField("schoolphone", "''><i>X</i>");
		
		tester.clickButtonWithText(" Update ");
		
		tester.assertElementNotPresentByXPath("//i");
	}
	
	@Test
	public void testAddress() {
		tester.setTextField("schooladdress", "''> <a href=\"http://unitn.it\">XSS</a> <input ");
		
		tester.clickButtonWithText(" Update ");
		
		tester.assertLinkNotPresentWithText("XSS");
	}
	
	@After
	public void cleanup() {
		// Needs to be done twice or the form breaks
		
		// Clean up address injection first
		tester.setTextField("schooladdress", "asd");
		tester.clickButtonWithText(" Update ");
		
		tester.setTextField("schooladdress", "asd");
		tester.clickButtonWithText(" Update ");
		
		//Clean up phone injection
		tester.setWorkingForm("info");
		
		tester.getElementByXPath("//form[@name='info']//tr[3]//input[@type='text']").setTextContent("123");
		tester.clickButtonWithText(" Update ");
		
		tester.setTextField("schoolphone", "123");
		tester.clickButtonWithText(" Update ");
	}
}
