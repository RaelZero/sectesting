package schoolmate;

import net.sourceforge.jwebunit.junit.WebTester;

public class User {
	public WebTester tester;
	
	public User() {
		tester = new WebTester();
		//tester.setBaseUrl("http://192.168.56.102/schoolmate/"); //Fixed version
		tester.setBaseUrl("http://192.168.56.102/origSchoolmate/"); //Vulnerable version
	}
	
}
