package schoolmate.admin;

import org.junit.*;
import schoolmate.Admin;

public class EditAnnouncements41 extends Admin{
	@Before
	public void init() {
		tester.clickLinkWithExactText("Announcements");
		tester.assertMatch("Manage Announcements");
		
		tester.setWorkingForm("announcements");
		addSubmitButton("//form[@name='announcements']");
	}

	@Test
	public void testPage() {
		tester.checkCheckbox("delete[]");
		this.genericTestPage("1", "19", "Edit Announcement");
	}
	
	@Test
	public void testPage2(){
		tester.checkCheckbox("delete[]");
		this.genericTestPage2("19", "Edit Announcement");
	}
	
	@Test
	public void testDelete(){
		this.genericTestDelete();
	}
}
